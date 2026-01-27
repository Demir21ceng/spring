package com.mycompany.todowithspring1.controller;

import com.mycompany.todowithspring1.dto.DetailsCreateRequest;
import com.mycompany.todowithspring1.dto.DetailsResponse;
import com.mycompany.todowithspring1.model.Details;
import com.mycompany.todowithspring1.services.DetailsServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos/{duty}/details")
public class DetailsRestController {

    private final DetailsServices detailsServices;

    public DetailsRestController(DetailsServices detailsServices) {
        this.detailsServices = detailsServices;
    }

    // ---- LIST ----
    @GetMapping
    @Operation(summary = "Todo'ya ait detayları listeler")
    public ResponseEntity<List<DetailsResponse>> getDetails(
            @PathVariable String duty
    ) {
        List<DetailsResponse> response = detailsServices
                .getDetailsByTodoDuty(duty)
                .stream()
                .map(d -> new DetailsResponse(d.getId(), d.getTitle()))
                .toList();

        return ResponseEntity.ok(response);
    }

    // ---- CREATE ----
    @PostMapping
    @Operation(summary = "Todo'ya yeni detail ekler")
    public ResponseEntity<Void> createDetail(
            @PathVariable String duty,
            @Valid @RequestBody DetailsCreateRequest request
    ) {
        detailsServices.createDetails(request.getTitle(), duty);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // ---- DELETE ----
    @DeleteMapping("/api/details/{id} ")
    @Operation(summary = "Todo'dan detail siler")
    public ResponseEntity<Void> deleteDetail(
            @PathVariable Long detailId
    ) {
        System.out.println("details rest controller");
        detailsServices.deleteDetails(detailId);
        return ResponseEntity.noContent().build();
    }

}
