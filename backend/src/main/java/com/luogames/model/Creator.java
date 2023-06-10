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
public class Creator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer creatorId;

    @Column(length = 500)
    private String urlProfileImage;

    @Column(length = 500)
    private String urlPosterImage;

    @Column(length = 50, nullable = false)
    @NonNull
    private String name;

    @Column(length = 300, nullable = false)
    @NonNull
    private String presentation;

    @Column(length = 50, nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(length = 200, nullable = false)
    @NonNull
    private String password;

    private Float earnings = 0f;

    // Associations -------------------------------------------------------------------------
    @OneToMany(mappedBy = "creator")
    @ToString.Exclude
    private List<Tip> tips = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    @ToString.Exclude
    private List<ContactLink> contactLinks = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    @ToString.Exclude
    private List<Game> games = new ArrayList<>();

    @ManyToMany(mappedBy = "creatorsFollowing")
    private List<Customer> followers = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<RefundRequest> refundRequests = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Offer> offers = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<CategoryRequest> categoryRequests = new ArrayList<>();
}
