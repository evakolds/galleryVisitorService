package com.gallery.visitor.service;

import com.gallery.visitor.model.Visitor;
import com.gallery.visitor.model.WithdrawDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getVisitorById(UUID id) {
        return visitorRepository.findById(id).get();
    }

    @Override
    public Visitor updateVisitorBalance(UUID visitorId, WithdrawDto toWithdraw) {
        Visitor visitor = visitorRepository.findById(visitorId).get();
        if (visitor.getMoney() <= toWithdraw.getToWithdraw())
            throw new IllegalArgumentException("Not enough money");
        visitor.setMoney(visitor.getMoney() - toWithdraw.getToWithdraw());
        visitorRepository.save(visitor);
        return visitor;
    }

    @Override
    public void deleteVisitorById(UUID id) {
        visitorRepository.deleteById(id);
    }

}
