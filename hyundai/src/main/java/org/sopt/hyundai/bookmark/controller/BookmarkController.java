package org.sopt.hyundai.bookmark.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.bookmark.service.BookmarkService;
import org.sopt.hyundai.bookmark.service.dto.BookMarkCreateRequest;
import org.sopt.hyundai.bookmark.service.dto.BookmarkStatusResponse;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/bookmarks")
    public ResponseEntity<ApiResponse> addLike(@RequestBody BookMarkCreateRequest bookMarkCreateRequest) {
        boolean isBookmarked = bookmarkService.addLike(bookMarkCreateRequest);
        BookmarkStatusResponse response = new BookmarkStatusResponse(isBookmarked);
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.BOOKMARK_SUCCESS, response));
    }
}