package com.mycompany.todowithspring1.dto;

import com.mycompany.todowithspring1.model.Importance;
import com.mycompany.todowithspring1.model.CompletionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTodoRequest {
    @NotBlank(message = "Duty cannot be blank")
    private String duty;

    @NotNull(message = "Importance isrequierd")
    private Importance importance;

    private CompletionStatus completionStatus;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setCompletionStatus(CompletionStatus completionStatus) {
        this.completionStatus = completionStatus;
    }

    public CompletionStatus getCompletionStatus() {
        return completionStatus;
    }
}
