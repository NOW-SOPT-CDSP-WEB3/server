package org.sopt.hyundai.member.service.dto;

public record MemberLoginResponse(
        Long userId,
        String email
) {
}
