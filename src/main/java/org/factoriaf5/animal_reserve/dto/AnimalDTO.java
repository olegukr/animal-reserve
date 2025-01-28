package org.factoriaf5.animal_reserve.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor 
// public class AnimalDTO {
//     private String name;
//     private String type;
//     private String family;
//     private String gender;
//     private String country;
//     private String dateOfEntry;
// }


// import lombok.Data;
// import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Required for frameworks like Hibernate
public class AnimalDTO {
    private Long id;
    private String name;
    private String type;
    private String family;
    private String gender;
    private String country;
    private String dateOfEntry;

// Manually add a constructor
public AnimalDTO(Long id, String name, String type, String family, String gender, String country, String dateOfEntry) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.family = family;
    this.gender = gender;
    this.country = country;
    this.dateOfEntry = dateOfEntry;
    }
}

