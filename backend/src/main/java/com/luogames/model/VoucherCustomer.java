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
public class VoucherCustomer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer voucherCustomerId;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @NonNull
    private VoucherStatus status;

    // Associations -------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Customer customer;

    @ManyToOne
    @NonNull
    private Voucher voucher;

    @ManyToOne
    private Purchase purchase;
}
