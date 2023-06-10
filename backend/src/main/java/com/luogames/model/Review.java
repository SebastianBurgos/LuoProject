package com.luogames.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer reviewId;

    @Column(nullable = false)
    @NonNull
    private Float rating;

    @Column(length = 500)
    private String comment;

    // Associations ---------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Game game;

    @ManyToOne
    @NonNull
    private Customer customer;
}
