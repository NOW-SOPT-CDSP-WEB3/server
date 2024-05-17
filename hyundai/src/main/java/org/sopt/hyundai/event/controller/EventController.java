package org.sopt.hyundai.event.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.sopt.hyundai.event.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @Operation(summary = "이벤트 리스트 조회 API", description = "모든 이벤트를 조회합니다.")
    @GetMapping
    public ResponseEntity<ApiResponse> getAllEvents(
            @RequestParam(required = false) String content
    ){
        if (content == null)
            content = "";
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_EVENT_LIST_SUCCESS, eventService.findAllEvent(content)));
    }
}
