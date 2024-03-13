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
import com.example.eventmanagementsystem.service.SponsorJpaService;

@RestController
public class SponsorController {

    @Autowired
    private SponsorJpaService service;

    @GetMapping("/events/sponsors")
    public ArrayList<Sponsor> getSponsors() {
        return service.getSponsors();
    }

    @GetMapping("/events/sponsors/{id}")
    public Sponsor getSponsorById(@PathVariable("id") int id) {
        return service.getSponsorById(id);
    }

    @PostMapping("/events/sponsors")
    public Sponsor addSponsor(@RequestBody Sponsor sponsor) {
        return service.addSponsor(sponsor);
    }

    @PutMapping("/events/sponsors/{id}")
    public Sponsor updateSponsor(@PathVariable("id") int id, @RequestBody Sponsor sponsor) {
        return service.updateSponsor(id, sponsor);
    }

    @DeleteMapping("/events/sponsors/{id}")
    public void deleteSponsor(@PathVariable("id") int id) {
        service.deleteSponsor(id);
    }

}
