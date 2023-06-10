package com.luogames.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer categoryId;

    @Column(length = 30, nullable = false, unique = true)
    @NonNull
    private String name;

    // Association ------------------------------------------------------------------------------
    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    private List<Game> games = new ArrayList<>();

    @ManyToMany(mappedBy = "categoriesInterested")
    @ToString.Exclude
    private List<Customer> customers;
}
