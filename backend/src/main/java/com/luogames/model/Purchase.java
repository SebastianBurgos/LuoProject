package com.luogames.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer purchaseId;

    @Column(nullable = false)
    @NonNull
    private LocalDateTime purchaseDate;

    private Float totalValue = 0f;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NonNull
    private PaymentMethod paymentMethod;

    private Integer spentCoins;

    // Associations ------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Customer customer;

    @OneToMany(mappedBy = "purchase")
    @ToString.Exclude
    private List<VoucherCustomer> voucherCustomerList;

    @ManyToOne
    private Offer offer;

    @ManyToOne
    private Game game;

    @OneToMany(mappedBy = "purchase")
    @ToString.Exclude
    private List<RefundRequest> refundRequests;
}
