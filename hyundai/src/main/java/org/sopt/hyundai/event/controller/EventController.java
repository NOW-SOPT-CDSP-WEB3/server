package org.sopt.hyundai.event.controller;

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
    @GetMapping
    public ResponseEntity<ApiResponse> getAllEvents(
            @RequestParam(required = false) String content
    ){
        if (content == null)
            content = "";
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_EVENT_LIST_SUCCESS, eventService.findAllEvent(content)));
    }
}
