package org.sopt.hyundai.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 내부 오류입니다."),
    NOT_FOUND_END_POINT(HttpStatus.NOT_FOUND.value(), "존재하지 않는 API입니다."),
    ;
    private final int status;
    private final String message;
}
