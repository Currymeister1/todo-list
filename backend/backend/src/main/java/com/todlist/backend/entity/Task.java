package com.todlist.backend.entity;

import java.time.LocalDate;


public class Task {
    private Long id;
    private String name;
    private String description;
    private LocalDate started;
    private LocalDate ended;
    private String issuer;
    private String category;

    public Task(){}
    public Task(Long id, String name, String description, LocalDate started, LocalDate ended, String issuer, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.started = started;
        this.ended = ended;
        this.issuer = issuer;
        this.category = category;
    }

    public Task(String name, String description, LocalDate started, LocalDate ended, String issuer, String category) {
        this.name = name;
        this.description = description;
        this.started = started;
        this.ended = ended;
        this.issuer = issuer;
        this.category = category;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStarted() {
        return started;
    }

    public void setStarted(LocalDate started) {
        this.started = started;
    }

    public LocalDate getEnded() {
        return ended;
    }

    public void setEnded(LocalDate ended) {
        this.ended = ended;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
