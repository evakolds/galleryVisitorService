package com.gallery.visitor.rabbitmq;

import com.gallery.visitor.model.Visitor;
import com.gallery.visitor.service.VisitorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    VisitorService visitorService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(Visitor visitor) {
        visitorService.addVisitor(visitor);
    }
}
