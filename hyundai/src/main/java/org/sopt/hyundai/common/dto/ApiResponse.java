package org.sopt.hyundai.common.dto;


public record ApiResponse(
        int status,
        boolean success,
        Object data,
        String message
) {
    public static ApiResponse of(ErrorCode errorCode){
        return new ApiResponse(errorCode.getStatus(), false, null, errorCode.getMessage());
    }
    public static ApiResponse of(SuccessCode successCode, Object data){
        return new ApiResponse(successCode.getStatus(), true, data, successCode.getMessage());
    }
}
