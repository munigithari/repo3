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
public class SponsorJpaService implements SponsorRepository {

    @Autowired
    private SponsorJpaRepository repository;

    @Override
    public ArrayList<Sponsor> getSponsors() {
        List<Sponsor> list = repository.findAll();
        ArrayList<Sponsor> sponsors = new ArrayList<>(list);
        return sponsors;
    }

    @Override
    public Sponsor getSponsorById(int id) {
        try {
            Sponsor sponsor = repository.findById(id).get();
            return sponsor;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Sponsor addSponsor(Sponsor sponsor) {
        repository.save(sponsor);
        return sponsor;
    }

    @Override 
    public Sponsor updateSponsor(int id, Sponsor sponsor) {
        try {
            Sponsor sponsors = repository.findById(id).get();
            if(sponsor.getName() != null) {
                sponsors.setName(sponsor.getName());
            }
            if(sponsor.getIndustry() != null) {
                sponsors.setIndustry(sponsor.getIndustry());
            }

            repository.save(sponsors);
            return sponsors;
        }  catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteSponsor(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
