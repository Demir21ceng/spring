package com.mycompany.todowithspring1.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoUpdateStatusRequest {
    @NotBlank(message = "Duty boş olamaz")
    private String duty;

    public String getDuty() {
        return duty;
    }
}
