package io.bosch.bookLibrary.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(targetEntity = BookEntity.class, mappedBy = "author")
    private Set<BookEntity> bookSet;
}
