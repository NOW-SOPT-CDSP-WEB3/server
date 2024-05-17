package org.sopt.hyundai.bookmark.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.bookmark.domain.Bookmark;
import org.sopt.hyundai.bookmark.repository.BookmarkRepository;
import org.sopt.hyundai.bookmark.service.dto.BookMarkCreateRequest;
import org.sopt.hyundai.card.domain.Card;
import org.sopt.hyundai.card.service.CardService;
import org.sopt.hyundai.member.domain.Member;
import org.sopt.hyundai.member.service.MemberService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final MemberService memberService;
    private final CardService cardService;
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public boolean addLike(BookMarkCreateRequest bookMarkCreateRequest) {
        Member member = memberService.findById(bookMarkCreateRequest.memberId());
        Card card = cardService.findById(bookMarkCreateRequest.cardId());

        // 이미 북마크를 한 경우 북마크를 해제하고, 아닌 경우 북마크를 추가.
        if (bookmarkRepository.existsByMemberAndCard(member, card)) {
            bookmarkRepository.deleteByMemberAndCard(member, card);
            return false;
        } else {
            Bookmark bookmark = Bookmark.create(member, card);
            bookmarkRepository.save(bookmark);
            return true;
        }
    }
}