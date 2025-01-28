package org.factoriaf5.animal_reserve.model;

import java.util.Date;

import org.factoriaf5.animal_reserve.dto.AnimalDTO;

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

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private AnimalFamily family;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Temporal(TemporalType.DATE)
    private Date dateOfEntry;

    private String image;

    public Animal() {}

    // Constructor for creating DTO from Entity
    public AnimalDTO toDTO() {
        return new AnimalDTO(
                this.id,
                this.name,
                this.type.getTypeName(),
                this.family.getFamilyName(),
                this.gender.getGenderName(),
                this.country.getCountryName(),
                this.dateOfEntry.toString()
        );
    }

    // Getters and setters

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

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public void setFamily(AnimalFamily family) {
        this.family = family;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
