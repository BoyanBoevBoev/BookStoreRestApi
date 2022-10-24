package io.bosch.bookLibrary.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
    @OneToMany(targetEntity = Order.class, mappedBy = "user")
    private Set<Order> orderSet;
}
