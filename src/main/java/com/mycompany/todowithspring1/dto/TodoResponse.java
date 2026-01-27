package com.mycompany.todowithspring1.dto;

import com.mycompany.todowithspring1.model.CompletionStatus;
import com.mycompany.todowithspring1.model.Importance;

import java.time.LocalDate;

public class TodoResponse {

    private Long id;
    private String duty;
    private Importance importance;
    private CompletionStatus completionStatus;
    private LocalDate date;

    public TodoResponse(
            Long id,
            String duty,
            Importance importance,
            CompletionStatus completionStatus,
            LocalDate date
    ) {
        this.id = id;
        this.duty = duty;
        this.importance = importance;
        this.completionStatus = completionStatus;
        this.date = date;

    }

    public Long getId() { return id; }
    public String getDuty() { return duty; }
    public Importance getImportance() { return importance; }
    public CompletionStatus getCompletionStatus() { return completionStatus; }
    public LocalDate getDate() {return date;}

}
