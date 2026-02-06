package com.mycompany.todowithspring1.dto;

import jakarta.validation.constraints.NotNull;

public class DetailsDeleteRequest {
    @NotNull
    private Long id;

    @NotNull
    private String duty;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public DetailsDeleteRequest() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id =  id; }
}
