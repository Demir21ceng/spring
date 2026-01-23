package com.mycompany.todowithspring1.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoDeleteRequest {
    public String getDuty() {
        return duty;
    }

    @NotBlank(message = "Duty not be empty")
    private String duty;

}
