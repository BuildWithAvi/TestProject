package com.example.db.entity.primary;

import jakarta.persistence.*;

@Entity
@Table(name = "primary_entity")
public class PrimaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public PrimaryEntity() {}
    public PrimaryEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
