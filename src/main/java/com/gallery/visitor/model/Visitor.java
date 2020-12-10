package com.gallery.visitor.model;

import com.gallery.visitor.VisitorRequest;
import com.gallery.visitor.VisitorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class Visitor {

    @Id
    private UUID userId;

    private String name;
    private double money;
    private int age;

    public Visitor(String name, double money, int age) {
        userId = UUID.randomUUID();
        this.name = name;
        this.money = money;
        this.age = age;
    }

    public static Visitor fromVisitorRequest(VisitorRequest visitorRequest) {
        return new Visitor(UUID.randomUUID(),
                visitorRequest.getName(),
                visitorRequest.getMoney(),
                visitorRequest.getAge());
    }

    public VisitorResponse toVisitorResponse() {
        return VisitorResponse.newBuilder().
                setId(userId.toString()).
                setName(name).
                setMoney(money).
                setAge(age).
                build();
    }
}
