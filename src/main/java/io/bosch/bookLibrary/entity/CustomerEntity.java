package io.bosch.bookLibrary.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    private String email;
    @OneToMany(targetEntity = OrderEntity.class, mappedBy = "customer")
    private Set<OrderEntity> orderSet;
}
