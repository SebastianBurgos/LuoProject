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
public class Tip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer tipId;

    @Column(nullable = false)
    @NonNull
    private Float value;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NonNull
    private PaymentMethod paymentMethod;

    // Associations ------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Creator creator;

    @ManyToOne
    @NonNull
    private Customer customer;
}
