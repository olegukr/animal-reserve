package org.factoriaf5.animal_reserve.dto;

public record AnimalDTO(
    Long id,
    String name,
    String type,
    String family,
    String gender,
    String country,
    String dateOfEntry
) {}
