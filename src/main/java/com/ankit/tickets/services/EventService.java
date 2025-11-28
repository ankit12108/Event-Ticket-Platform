package com.ankit.tickets.services;

import com.ankit.tickets.domain.CreateEventRequest;
import com.ankit.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
