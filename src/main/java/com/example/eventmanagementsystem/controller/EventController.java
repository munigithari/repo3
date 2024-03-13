/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.eventmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.example.eventmanagementsystem.model.*;
import com.example.eventmanagementsystem.service.EventJpaService;

@RestController
public class EventController {

    @Autowired
    private EventJpaService service;

    @GetMapping("/events")
    public ArrayList<Event> getEvents() {
        return service.getEvents();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable("id") int id) {
        return service.getEventById(id);
    }

    @PostMapping("/events")
    public Event addEvent(@RequestBody Event event) {
        return service.addEvent(event);
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(@PathVariable("id") int id, @RequestBody Event event) {
        return service.updateEvent(id, event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable("id") int id) {
        service.deleteEvent(id);
    }

}
