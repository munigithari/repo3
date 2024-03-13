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
import com.example.eventmanagementsystem.model.Sponsor;

public interface SponsorRepository {
    ArrayList<Sponsor> getSponsors();

    Sponsor getSponsorById(int id);

    Sponsor addSponsor(Sponsor sponsor);

    Sponsor updateSponsor(int id, Sponsor sponsor);

    void deleteSponsor(int id);

}