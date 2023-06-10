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
public class Voucher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer voucherId;

    @Column(length = 30, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(length = 10, nullable = false, unique = true)
    @NonNull
    private String code;

    @Column(nullable = false)
    @NonNull
    private Float discountValue;

    @Column(nullable = false)
    @NonNull
    private LocalDate expirationDate;

    @Column(nullable = false)
    @NonNull
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NonNull
    private Criteria criteria;

    // Association --------------------------------------------------------------------------------------
    @OneToMany(mappedBy = "voucher")
    @ToString.Exclude
    private List<VoucherCustomer> voucherCustomerList = new ArrayList<>();
}
