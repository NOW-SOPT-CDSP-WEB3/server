package org.sopt.hyundai.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.dto.ErrorCode;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;
}
