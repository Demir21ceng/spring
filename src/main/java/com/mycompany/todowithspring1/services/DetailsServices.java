/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.todowithspring1.services;

import com.mycompany.todowithspring1.dto.DetailsResponse;
import com.mycompany.todowithspring1.model.Details;
import java.util.List;


/**
 *
 * @author servan
 */

public interface DetailsServices {
    Long createDetails(String details, String todoDuty);
    void deleteDetails(Long detailsId);

    public List<DetailsResponse> getDetailsByTodoDuty(String duty);
}

