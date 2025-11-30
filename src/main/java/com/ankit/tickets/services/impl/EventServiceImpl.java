package com.ankit.tickets.services.impl;

import com.ankit.tickets.domain.CreateEventRequest;
import com.ankit.tickets.domain.entities.Event;
import com.ankit.tickets.domain.entities.TicketType;
import com.ankit.tickets.domain.entities.User;
import com.ankit.tickets.exception.UserNotFoundException;
import com.ankit.tickets.repositories.EventRepository;
import com.ankit.tickets.repositories.UserRepository;
import com.ankit.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest createEventRequest) {

        // 🔹 Step 1: Fetch organizer OR throw custom exception if not found
        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new UserNotFoundException(
                        "Organizer with ID '%s' not found".formatted(organizerId)
                ));
        Event event = new Event();

        // 🔹 Step 2: Convert incoming ticket types DTO → Entity
        List<TicketType> ticketTypes = createEventRequest.getTicketTypes()
                .stream()
                .map(ticketTypeRequest -> {
                    TicketType ticketType = new TicketType();
                    ticketType.setName(ticketTypeRequest.getName());
                    ticketType.setPrice(ticketTypeRequest.getPrice());
                    ticketType.setDescription(ticketTypeRequest.getDescription());
                    ticketType.setTotalAvailable(ticketTypeRequest.getTotalAvailable());
                    ticketType.setEvent(event);
                    return ticketType;
                })
                .toList();

        // 🔹 Step 3: Populate Event entity

        event.setName(createEventRequest.getName());
        event.setStart(createEventRequest.getStart());
        event.setEnd(createEventRequest.getEnd());
        event.setVenue(createEventRequest.getVenue());
        event.setSalesStart(createEventRequest.getSalesStart());
        event.setSalesEnd(createEventRequest.getSalesEnd());
        event.setStatus(createEventRequest.getStatus());
        event.setOrganizer(organizer);
        event.setTicketTypes(ticketTypes);   // Attach ticket types

        // 🔹 Step 4: Save event in DB
        return eventRepository.save(event);
    }
}
