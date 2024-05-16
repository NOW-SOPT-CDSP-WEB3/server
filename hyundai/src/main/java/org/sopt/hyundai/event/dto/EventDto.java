package org.sopt.hyundai.event.dto;

import org.sopt.hyundai.event.domain.Event;

public record EventDto(
        Long id,
        String image,
        String name,
        String description,
        String period
) {
    public static EventDto of(Event event){
        return new EventDto(event.getId(), event.getImage(), event.getName(), event.getDescription(), event.getPeriod());
    }
}
