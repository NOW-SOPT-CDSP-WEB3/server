package org.sopt.hyundai.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
    GET_CULTURE_LIST_SUCCESS(HttpStatus.OK.value(), "문화 리스트 조회에 성공했습니다.")
    ;
    private final int status;
    private final String message;
}
