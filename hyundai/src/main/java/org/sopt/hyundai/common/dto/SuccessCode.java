package org.sopt.hyundai.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
    MEMBER_CREATE_SUCCESS(201, "회원가입 성공"),
    MEMBER_LOGIN_SUCCESS(200, "로그인 성공")
    GET_CULTURE_LIST_SUCCESS(HttpStatus.OK.value(), "문화 리스트 조회에 성공했습니다."),
    GET_EVENT_LIST_SUCCESS(HttpStatus.OK.value(), "이벤트 리스트 조회에 성공했습니다.")
    ;
    private final int status;
    private final String message;
}
