package org.factoriaf5.animal_reserve.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonProperty("type")
    private AnimalType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "family_id", nullable = false)
    @JsonProperty("family")
    private AnimalFamily family;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", nullable = false)
    @JsonProperty("gender")
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    @JsonProperty("country")
    private Country country;

    @JsonProperty("dateOfEntry")
    @Temporal(TemporalType.DATE)
    private Date dateOfEntry;

    private String image;

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public AnimalFamily getFamily() {
        return family;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry() {
        return country;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public String getImage() {
        return image;
    }


    // Getters and setters
    // Constructor(s)
}
