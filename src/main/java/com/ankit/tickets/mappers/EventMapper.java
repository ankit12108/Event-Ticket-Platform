package com.ankit.tickets.mappers;

import com.ankit.tickets.domain.CreateEventRequest;
import com.ankit.tickets.domain.CreateTicketTypeRequest;
import com.ankit.tickets.domain.dtos.CreateEventRequestDto;
import com.ankit.tickets.domain.dtos.CreateEventResponseDto;
import com.ankit.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.ankit.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);
    CreateEventRequest fromDto(CreateEventRequestDto dto);
    CreateEventResponseDto toDto(Event event);
}

