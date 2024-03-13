/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.*;
 *
 */

// Write your code here
package com.example.eventmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.eventmanagementsystem.repository.*;
import com.example.eventmanagementsystem.model.*;

@Service
public class EventJpaService implements EventRepository {

    @Autowired
    private EventJpaRepository repository;

    @Override
    public ArrayList<Event> getEvents() {
        List<Event> list = repository.findAll();
        ArrayList<Event> events = new ArrayList<>(list);
        return events;
    }

    @Override
    public Event getEventById(int id) {
        try {
            Event event = repository.findById(id).get();
            return event;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Event addEvent(Event event) {
        repository.save(event);
        return event;
    }

    @Override
    public Event updateEvent(int id, Event event) {
        try {
            Event events = repository.findById(id).get();
            if (event.getName() != null) {
                events.setName(event.getName());
            }
            if (event.getDate() != null) {
                events.setDate(event.getDate());
            }

            repository.save(events);
            return events;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteEvent(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
