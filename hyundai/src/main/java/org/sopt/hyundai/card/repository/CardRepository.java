package org.sopt.hyundai.card.repository;

import org.sopt.hyundai.card.domain.Card;
import org.sopt.hyundai.card.domain.CardCategory;
import org.sopt.hyundai.card.domain.CardTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByCardCategoryAndCardTagsIn(CardCategory cardCategory, List<CardTag> cardTags);
}

