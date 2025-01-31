package org.factoriaf5.animal_reserve.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("countryName")
    @Column(nullable = false, unique = true)
    private String countryName;

    public Long getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

}
