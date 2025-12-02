/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todowithspring1.controller;

import com.mycompany.todowithspring1.model.Details;
import com.mycompany.todowithspring1.services.DetailsServices;
import java.util.List;

import org.springframework.stereotype.Controller;

/**
 *
 * @author servan
 */
@Controller
public class DetailsController {
    private final DetailsServices services;
    
    public DetailsController(DetailsServices services){
        this.services = services;
    }
    
     // ---- ADD DETAILS ----
    public Details addDetails(String details, String todoDuty) {
        return services.createDetails(details, todoDuty);
    }

    // ---- DELETE DETAILS ----
    public void deleteDetail(String details, String todoDuty) {
        services.deleteDetails(details, todoDuty);
    }

    // ---- LIST DETAILS ----
    public List<Details> getDetailsByDuty(String duty) {
        return services.getDetailsByTodoDuty(duty);
    }
}
