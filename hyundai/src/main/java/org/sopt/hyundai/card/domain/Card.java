package org.sopt.hyundai.card.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardCategory cardCategory;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean invitation;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private boolean hasEvent;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "card_tags", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "tag")
    private List<CardTag> cardTags;

    @Builder
    public Card(String name, boolean invitation, String description, String image, boolean hasEvent, CardCategory cardCategory, List<CardTag> cardTags) {
        this.name = name;
        this.invitation = invitation;
        this.description = description;
        this.image = image;
        this.hasEvent = hasEvent;
        this.cardCategory = cardCategory;
        this.cardTags = cardTags;
    }

    public static Card create(String name, boolean invitation, String description, String image, boolean hasEvent, CardCategory cardCategory, List<CardTag> cardTags) {
        return Card.builder()
                .name(name)
                .invitation(invitation)
                .description(description)
                .image(image)
                .hasEvent(hasEvent)
                .cardCategory(cardCategory)
                .cardTags(cardTags)
                .build();
    }
}