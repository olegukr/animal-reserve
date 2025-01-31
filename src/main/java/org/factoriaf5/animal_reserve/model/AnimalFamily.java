package org.factoriaf5.animal_reserve.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "animal_family")
public class AnimalFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("familyName")
    @Column(nullable = false, unique = true)
    private String familyName;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> animals;

    public AnimalFamily() {}
    
    public Long getId() {
        return id;
    }


    public String getFamilyName() {
        return familyName;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }


    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }


    public List<Animal> getAnimals() {
        return animals;
    }
    
}