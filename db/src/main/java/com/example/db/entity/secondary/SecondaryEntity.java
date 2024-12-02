package com.example.db.entity.secondary;

import jakarta.persistence.*;

@Entity
@Table(name = "secondary")
public class SecondaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public SecondaryEntity() {}
    public SecondaryEntity(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
