package org.sopt.hyundai.member.service.dto;

public record MemberCreateResponse(
        Long userId,
        String email
) {
}
