package com.mycompany.todowithspring1.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoDeleteRequest {

    public TodoDeleteRequest() {}

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    @NotBlank(message = "Duty not be empty")
    private String duty;

}
