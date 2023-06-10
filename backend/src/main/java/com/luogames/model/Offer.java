package com.luogames.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer offerId;

    @Column(length = 200, nullable = false)
    @NonNull
    private String description;

    @Column(nullable = false)
    @NonNull
    private LocalDate beginDate;

    @Column(nullable = false)
    @NonNull
    private LocalDate endDate;

    private Float savingPercentage;

    private Float discountValue;

    // Associations ---------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private OfferType offerType;

    @ManyToOne
    @NonNull
    private Creator creator;

    @ManyToMany(mappedBy = "offers")
    @ToString.Exclude
    private List<Game> games = new ArrayList<>();

    @OneToMany(mappedBy = "offer")
    @ToString.Exclude
    private List<Purchase> purchases;

}
