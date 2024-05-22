package org.sopt.hyundai.card.service.dto;

import org.sopt.hyundai.card.domain.Card;

import java.util.List;

public record CardResponse(
        Long id,
        String name,
        boolean invitation,
        String description,
        String image,
        boolean hasEvent,
        List<String> cardTags,
        int visaFee,
        int domesticFee
) {
    public static CardResponse from(Card card) {
        return new CardResponse(
                card.getId(),
                card.getName(),
                card.isInvitation(),
                card.getDescription(),
                card.getImage(),
                card.isHasEvent(),
                card.getCardTags().stream()
                        .map(Enum::name)
                        .toList(),
                card.getVisaFee(),
                card.getDomesticFee()
        );
    }
}
