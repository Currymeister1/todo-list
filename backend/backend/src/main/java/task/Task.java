package task;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private String issuer;
    private String category;


    public Task(Long id, String name, String description, LocalDate start, LocalDate end, String issuer, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.issuer = issuer;
        this.category = category;
    }

    public Task(String name, String description, LocalDate start, LocalDate end, String issuer, String category) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.issuer = issuer;
        this.category = category;
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

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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
