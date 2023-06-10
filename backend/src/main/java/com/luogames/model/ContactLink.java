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
public class ContactLink implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer contactLinkId;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @NonNull
    private SocialMediaPlatform platform;

    @Column(length = 500, nullable = false)
    @NonNull
    private String url;

    // Association -----------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Creator creator;
}
