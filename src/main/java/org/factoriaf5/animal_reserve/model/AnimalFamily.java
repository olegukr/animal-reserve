package org.factoriaf5.animal_reserve.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnimalFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("familyName")
    @Column(nullable = false, unique = true)
    private String familyName;

    public Long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    // Getters and setters
    // Constructor(s)
}
