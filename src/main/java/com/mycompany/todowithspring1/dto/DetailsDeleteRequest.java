package com.mycompany.todowithspring1.dto;

import jakarta.validation.constraints.NotNull;

public class DetailsDeleteRequest {
    @NotNull
    private Long detailId;

    @NotNull
    private String duty;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public DetailsDeleteRequest() {}

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
}
