package org.sopt.hyundai.common;

import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.ErrorCode;
import org.sopt.hyundai.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse> handleBusinessException(BusinessException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(ApiResponse.of(e.getErrorCode()));
    }

    // 존재하지 않는 요청에 대한 예외
    @ExceptionHandler(value = {NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ApiResponse> handleNoPageFoundException(Exception e) {
        return ResponseEntity
                .status(ErrorCode.NOT_FOUND_END_POINT.getStatus())
                .body(ApiResponse.of(ErrorCode.NOT_FOUND_END_POINT));
    }

    // 기본 예외
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return ResponseEntity
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiResponse.of(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}
