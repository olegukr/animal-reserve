package org.factoriaf5.animal_reserve.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType type;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private AnimalFamily family;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Temporal(TemporalType.DATE)
    private Date dateOfEntry;

    private String image;

    // Getters and setters
    // Constructor(s)
}
