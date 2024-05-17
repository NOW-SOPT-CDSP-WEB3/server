package org.sopt.hyundai.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
    MEMBER_CREATE_SUCCESS(201, "회원가입 성공"),
    MEMBER_LOGIN_SUCCESS(200, "로그인 성공")
    ;
    private final int status;
    private final String message;
}
