package com.mycompany.todowithspring1.dto;

import jakarta.validation.constraints.NotBlank;

public class DetailsCreateRequest {
   @NotBlank
   private String title;
   @NotBlank
   private String duty;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getTitle() {
        return title;
    }
}
