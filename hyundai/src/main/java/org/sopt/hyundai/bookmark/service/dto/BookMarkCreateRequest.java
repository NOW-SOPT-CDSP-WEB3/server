package org.sopt.hyundai.bookmark.service.dto;

public record BookMarkCreateRequest(
        Long memberId,
        Long cardId
) {
}
