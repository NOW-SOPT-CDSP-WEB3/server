package org.sopt.hyundai.card.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.domain.CardCategory;
import org.sopt.hyundai.card.domain.CardTag;
import org.sopt.hyundai.card.service.CardService;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CardController {
    private final CardService cardService;

    @Operation(summary = "전체 카드 조회 API", description = "모든 카드를 조회합니다.")
    @GetMapping("/cards")
    public ResponseEntity<ApiResponse> getAllCards() {
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_ALL_CARD_LIST_SUCCESS, cardService.findAllCards()));
    }

    @Operation(summary = "카테고리별 태그 필터링 카드 조회 API", description = "카테고리별로 태그로 필터링하여 카드를 조회합니다.")
    @GetMapping("/cards/filter")
    public ResponseEntity<ApiResponse> getCardsByCategoryAndTags(
            @RequestParam("category") CardCategory category,
            @RequestParam("tags") List<CardTag> tags) {
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_CARD_LIST_SUCCESS, cardService.findByCategoryAndTags(category, tags)));
    }
}
