package org.sopt.hyundai.common.dto;


public record ApiResponse(
        int status,
        boolean success,
        String message,
        Object data
) {
    public static ApiResponse of(ErrorCode errorCode){
        return new ApiResponse(errorCode.getStatus(), false, errorCode.getMessage(), null);
    }
    public static ApiResponse of(SuccessCode successCode, Object data){
        return new ApiResponse(successCode.getStatus(), true, successCode.getMessage(), data);
    }
}
