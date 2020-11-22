package com.gallery.visitor.service;

import com.gallery.visitor.model.Visitor;
import com.gallery.visitor.model.WithdrawDto;

import java.util.List;
import java.util.UUID;

public interface VisitorService {

    Visitor addVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(UUID id);

    Visitor updateVisitorBalance(UUID visitorId, WithdrawDto newBalance);

    void deleteVisitorById(UUID id);

}
