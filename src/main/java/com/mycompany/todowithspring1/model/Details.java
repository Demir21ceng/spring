package com.mycompany.todowithspring1.model;


import jakarta.persistence.*;

@Entity
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id otomatik artacak
    private Long id;

    @Column(nullable = false)
    private String details;
    // Detail -> Todo ilişkisi (her detay bir Todo’ya bağlı)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    // ----- Constructors -----
    public Details() {}

    public Details(String title, Todo todo) {
        this.details = title;
        this.todo = todo;
    }

    // ----- Getters & Setters -----
    public Long getId() { return id; }

    public String getTitle() {  return details;}
    public void setTitle(String details) { this.details = details;}
    
    public Todo getTodo() { return todo; }
    public void setTodo(Todo todo) { this.todo = todo; }
}
