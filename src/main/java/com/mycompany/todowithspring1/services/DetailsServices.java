
package com.mycompany.todowithspring1.services;

import com.mycompany.todowithspring1.dto.DetailsResponse;
import com.mycompany.todowithspring1.model.Details;
import java.util.List;




public interface DetailsServices {
    Long createDetails(String details, String todoDuty);
    void deleteDetails(Long detailsId);

    public List<DetailsResponse> getDetailsByTodoDuty(String duty);
}

