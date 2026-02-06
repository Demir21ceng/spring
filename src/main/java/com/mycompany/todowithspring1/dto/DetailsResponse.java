package com.mycompany.todowithspring1.dto;

public class DetailsResponse {
    private Long id;
    private String title;

    public DetailsResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
