/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.todowithspring1.services;

import com.mycompany.todowithspring1.model.Details;
import java.util.List;


/**
 *
 * @author servan
 */

public interface DetailsServices {
    Details createDetails(String details, String todoDuty);
    void deleteDetails(String title, String todoDuty);
    List<Details> getDetailsByTodoDuty(String todoDuty);
}

