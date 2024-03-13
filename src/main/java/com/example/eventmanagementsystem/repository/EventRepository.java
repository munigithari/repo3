/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.eventmanagementsystem.repository;

import java.util.*;
import com.example.eventmanagementsystem.model.Event;

public interface EventRepository {
    ArrayList<Event> getEvents();

    Event getEventById(int id);

    Event addEvent(Event event);

    Event updateEvent(int id, Event event);

    void deleteEvent(int id);

}