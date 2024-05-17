package org.sopt.hyundai.card.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.domain.CardCategory;
import org.sopt.hyundai.card.domain.CardTag;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.service.CardService;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CardController {
    private final CardService cardService;

    @GetMapping("/cards")
    public ResponseEntity<ApiResponse> getAllCards() {
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_ALL_CARD_LIST_SUCCESS, cardService.findAllCards()));
    }

    @GetMapping("/cards/filter")
    public ResponseEntity<ApiResponse> getCardsByCategoryAndTags(
            @RequestParam("category") CardCategory category,
            @RequestParam("tags") List<CardTag> tags) {
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_CARD_LIST_SUCCESS, cardService.findByCategoryAndTags(category, tags)));
    }
}