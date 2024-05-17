package org.sopt.hyundai.card.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.domain.Card;
import org.sopt.hyundai.card.domain.CardCategory;
import org.sopt.hyundai.card.domain.CardTag;
import org.sopt.hyundai.card.repository.CardRepository;
import org.sopt.hyundai.card.service.dto.CardCategoryResponse;
import org.sopt.hyundai.card.service.dto.CardResponse;
import org.sopt.hyundai.card.service.dto.CardsListResponse;
import org.sopt.hyundai.common.dto.ErrorCode;
import org.sopt.hyundai.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public CardsListResponse findAllCards() {
        List<Card> cards = cardRepository.findAll();
        Map<CardCategory, List<Card>> groupedCards = cards.stream()
                .collect(Collectors.groupingBy(Card::getCardCategory));

        List<CardCategoryResponse> cardCategories = groupedCards.entrySet().stream()
                .map(entry -> CardCategoryResponse.of(
                        entry.getKey(),
                        entry.getValue().stream()
                                .map(CardResponse::from)
                                .toList()
                ))
                .toList();

        return CardsListResponse.from(cardCategories);
    }

    public CardsListResponse findByCategoryAndTags(CardCategory category, List<CardTag> tags) {
        List<Card> cards = cardRepository.findAllByCardCategoryAndCardTagsIn(category, tags);
        List<CardResponse> cardResponses = cards.stream()
                .map(CardResponse::from)
                .toList();

        return CardsListResponse.from(List.of(CardCategoryResponse.of(category, cardResponses)));
    }

    public Card findById(long cardId) {
        return cardRepository.findById(cardId).orElseThrow(
                () -> new BusinessException(ErrorCode.CARD_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }
}