package org.sopt.hyundai.card.repository;

import org.sopt.hyundai.card.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

}
