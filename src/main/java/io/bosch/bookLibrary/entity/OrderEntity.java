package io.bosch.bookLibrary.entity;

import javax.persistence.*;
import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(targetEntity = BookEntity.class,mappedBy = "orderSet")
    private Set<BookEntity> bookSet;
    @ManyToOne
    private CustomerEntity customer;
    private LocalDate localDate;
}
