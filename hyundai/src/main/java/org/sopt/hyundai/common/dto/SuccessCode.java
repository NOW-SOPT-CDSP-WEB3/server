package org.sopt.hyundai.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
    MEMBER_CREATE_SUCCESS(201, "회원가입 성공"),
    MEMBER_LOGIN_SUCCESS(200, "로그인 성공"),
    GET_CARD_LIST_SUCCESS(200, "카드 리스트 조회 성공"),
    BOOKMARK_SUCCESS(200, "북마크 요청이 성공했습니다.")
    ;
    private final int status;
    private final String message;
}
