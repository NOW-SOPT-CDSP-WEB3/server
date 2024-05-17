package org.sopt.hyundai.card.service.dto;


import java.util.List;

public record CardsListResponse(
        List<CardCategoryResponse> cards
) {
    public static CardsListResponse from(List<CardCategoryResponse> cards) {
        return new CardsListResponse(cards);
    }
}