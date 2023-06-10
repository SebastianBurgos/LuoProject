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
public class CategoryRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer categoryRequestId;

    @Column(length = 30, nullable = false)
    @NonNull
    private String newCategoryRequested;

    @Column(length = 300, nullable = false)
    @NonNull
    private String details;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private RequestStatus status = RequestStatus.NOT_REVIEWED;

    // Associations -----------------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Creator creator;
}
