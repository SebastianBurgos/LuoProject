package com.luogames.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OfferType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer offerTypeId;

    @Column(length = 50, nullable = false)
    @NonNull
    private String name;

    @Column(length = 200, nullable = false)
    @NonNull
    private String details;

    @Column(nullable = false)
    @NonNull
    private Integer maxGameLimit;

    // Association --------------------------------------------------------------------------------
    @OneToMany(mappedBy = "offerType")
    @ToString.Exclude
    private List<Offer> offers = new ArrayList<>();
}
