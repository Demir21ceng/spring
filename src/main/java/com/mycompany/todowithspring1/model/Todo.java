package com.mycompany.todowithspring1.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String duty;

    //  DB yönetiyor → JPA sadece okur
    @Column(
            nullable = false,
            insertable = false,
            updatable = false
    )
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Importance importance;

    @Enumerated(EnumType.STRING)
    @Column(name = "completionstatus", nullable = false)
    private CompletionStatus completionStatus;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Details> details = new ArrayList<>();

    // ----- Constructors -----
    public Todo() {}

    public Todo(String duty, Importance importance, CompletionStatus completionStatus) {
        this.duty = duty;
        this.importance = importance;
        this.completionStatus = completionStatus;
    }

    // ----- Getters & Setters -----
    public Long getId() { return id; }

    public String getDuty() { return duty; }
    public void setDuty(String duty) { this.duty = duty; }

    public LocalDate getDate() { return date; }


    public Importance getImportance() { return importance; }
    public void setImportance(Importance importance) { this.importance = importance; }

    public CompletionStatus getCompletionStatus() { return completionStatus; }
    public void setCompletionStatus(CompletionStatus completionStatus) { this.completionStatus = completionStatus; }

    public List<Details> getDetails() { return details; }

    // ----- Yardımcı metodlar -----
    public void addDetail(Details detail) {
        details.add(detail);
        detail.setTodo(this);
    }

    public void removeDetail(Details detail) {
        details.remove(detail);
        detail.setTodo(null);
    }
}
