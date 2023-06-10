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
public class RefundRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer refundRequestId;

    @Column(length = 100, nullable = false)
    @NonNull
    private String reason;

    @Column(length = 400, nullable = false)
    @NonNull
    private String details;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private RequestStatus status = RequestStatus.NOT_REVIEWED;

    // Associations ----------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Customer customer;

    @ManyToOne
    @NonNull
    private Purchase purchase;

    @ManyToOne
    @NonNull
    private Creator creator;

    @OneToOne
    private Refund refund;
}
