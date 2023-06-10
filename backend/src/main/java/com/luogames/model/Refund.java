package com.luogames.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Refund implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer refundId;

    @Column(length = 300, nullable = false)
    private String response;

    private Float value;

    // Associations -----------------------------------------------------------------------
    @OneToOne
    private RefundRequest refundRequest;
}
