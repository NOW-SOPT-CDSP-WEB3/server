package org.sopt.hyundai.member.repository;

import org.sopt.hyundai.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
