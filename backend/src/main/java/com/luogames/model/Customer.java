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
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer customerId;

    @Column(length = 50, nullable = false)
    @NonNull
    private String fullName;

    @Column(length = 15, nullable = false, unique = true)
    @NonNull
    private String dni;

    @Column(length = 500)
    private String urlProfileImage;

    @Column(nullable = false)
    @NonNull
    private LocalDate birthdate;

    @Column(length = 50, nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(length = 200, nullable = false)
    @NonNull
    private String password;

    @Column(nullable = false)
    private Integer coins = 0;

    @Column(nullable = false)
    private Integer achievements = 0;

    // Associations ----------------------------------------------------------------------------
    @ManyToMany(mappedBy = "customers")
    @ToString.Exclude
    private List<Category> categoriesInterested;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<GameCustomer> gameCustomerList = new ArrayList<>();

    @ManyToMany(mappedBy = "potentialCustomers")
    @ToString.Exclude
    private List<Game> wishList = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<VoucherCustomer> voucherCustomerList = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Tip> tips = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Purchase> purchases = new ArrayList<>();

    @ManyToMany(mappedBy = "followers")
    @ToString.Exclude
    private List<Creator> creatorsFollowing = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<RefundRequest> refundRequests = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}
