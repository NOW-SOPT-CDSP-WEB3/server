package org.sopt.hyundai.card.service.dto;

import org.sopt.hyundai.card.domain.CardCategory;

import java.util.List;

public record CardCategoryResponse(
        CardCategory cardCategory,
        List<CardResponse> card
) {
    public static CardCategoryResponse of(CardCategory category, List<CardResponse> card) {
        return new CardCategoryResponse(category, card);
    }
}
