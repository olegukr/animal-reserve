package org.factoriaf5.animal_reserve.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class AnimalDTO {
    private String name;
    private String type;
    private String family;
    private String gender;
    private String country;
    private String dateOfEntry;
}

