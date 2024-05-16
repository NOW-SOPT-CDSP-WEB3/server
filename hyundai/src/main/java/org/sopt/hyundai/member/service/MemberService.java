package org.sopt.hyundai.member.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.member.domain.Member;
import org.sopt.hyundai.member.repository.MemberRepository;
import org.sopt.hyundai.member.service.dto.MemberCreateRequest;
import org.sopt.hyundai.member.service.dto.MemberCreateResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberCreateResponse createMember(MemberCreateRequest memberCreateRequest) {
        Member member = memberRepository.save(Member.create(memberCreateRequest.email(), memberCreateRequest.password()));
        return new MemberCreateResponse(member.getId(), member.getEmail());
    }
}
