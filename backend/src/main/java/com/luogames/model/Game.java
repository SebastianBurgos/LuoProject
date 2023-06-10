package com.luogames.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer gameId;

    @Column(length = 80, nullable = false)
    @NonNull
    private String name;

    @Column(length = 500, nullable = false)
    @NonNull
    private String description;

    @Column(nullable = false)
    @NonNull
    private Float price;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Classification esrbClassification;

    @Column(length = 500)
    private String urlMainImage;

    private LocalDateTime releaseDate;

    @Column(length = 500)
    private String minimumSystemRequirements;

    @Column(length = 500)
    private String recommendedSystemRequirements;

    private Float chargePercentage = 0f;

    private Float chargeValue = 0f;

    // Associations -------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Creator creator;

    @ManyToMany(mappedBy = "games")
    @ToString.Exclude
    private List<Category> categories;

    @OneToMany(mappedBy = "game")
    @ToString.Exclude
    private List<GameCustomer> gameCustomerList = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    @ToString.Exclude
    private List<Purchase> purchases = new ArrayList<>();

    @ManyToMany(mappedBy = "wishList")
    @ToString.Exclude
    private List<Customer> potentialCustomers = new ArrayList<>();

    @ManyToMany(mappedBy = "games")
    @ToString.Exclude
    private List<Offer> offers = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}
