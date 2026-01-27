package com.mycompany.todowithspring1.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoUpdateStatusRequest {
    @NotBlank(message = "Duty boş olamaz")
    private String duty;

    public TodoUpdateStatusRequest(){}

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }
}
