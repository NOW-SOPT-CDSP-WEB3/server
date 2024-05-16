package org.sopt.hyundai.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
    MEMBER_CREATE_SUCCESS(200, "성공");
    ;
    private final int status;
    private final String message;
}
