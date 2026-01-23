package com.mycompany.todowithspring1.dto;

import com.mycompany.todowithspring1.model.Importance;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TodoUptadeImportanceRequest {
    @NotBlank(message = "Duty boş olamaz")
    private String duty;

    @NotNull(message = "Importance boş olamaz")
    private Importance importance;

    public String getDuty() {
        return duty;
    }

    public Importance getImportance() {
        return importance;
    }
}
