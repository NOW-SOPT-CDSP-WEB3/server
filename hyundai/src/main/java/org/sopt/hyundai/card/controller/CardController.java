package org.sopt.hyundai.card.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.card.service.CardService;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CardController {
    private final CardService cardService;

    @GetMapping("/cards")
    public ResponseEntity<ApiResponse> getAllCards() {
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_CARD_LIST_SUCCESS, cardService.findAllCards()));
    }
}