package org.sopt.hyundai.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부 오류입니다."),
    NOT_FOUND_END_POINT(HttpStatus.NOT_FOUND.value(), "존재하지 않는 API 입니다."),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST.value(), "이미 존재하는 이메일입니다."),
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED.value(), "로그인에 실패하였습니다. 잘못된 이메일 또는 비밀번호입니다.");
    ;
    private final int status;
    private final String message;
}
