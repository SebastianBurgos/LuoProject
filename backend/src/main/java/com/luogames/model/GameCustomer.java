package com.luogames.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GameCustomer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer gameCustomerId;

    @Column(nullable = false)
    @Type(type = "YES_NO")
    @NonNull
    private Boolean offerBought;

    // Associations ----------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Game game;

    @ManyToOne
    @NonNull
    private Customer customer;

}
