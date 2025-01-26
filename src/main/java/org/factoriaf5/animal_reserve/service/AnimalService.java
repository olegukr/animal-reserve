package org.factoriaf5.animal_reserve.service;

import java.util.List;
import java.util.stream.Collectors;

import org.factoriaf5.animal_reserve.dto.AnimalDTO;
import org.factoriaf5.animal_reserve.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Page<AnimalDTO> getPaginatedAnimals(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findAll(pageable)
                .map(animal -> new AnimalDTO(
                        animal.getName(),
                        animal.getType().getTypeName(),
                        animal.getFamily().getFamilyName(),
                        animal.getGender().getGenderName(),
                        animal.getCountry().getCountryName(),
                        animal.getDateOfEntry().toString()
                ));
    }

    public Page<AnimalDTO> getAnimalsByFamily(String family, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findByFamilyFamilyName(family, pageable)
                .map(animal -> new AnimalDTO(
                        animal.getName(),
                        animal.getType().getTypeName(),
                        animal.getFamily().getFamilyName(),
                        animal.getGender().getGenderName(),
                        animal.getCountry().getCountryName(),
                        animal.getDateOfEntry().toString()
                ));
    }
    
    public List<AnimalDTO> getAnimalsByCountry(String country) {
    return animalRepository.findByCountryCountryName(country)
            .stream()
            .map(animal -> new AnimalDTO(
                    animal.getName(),
                    animal.getType().getTypeName(),
                    animal.getFamily().getFamilyName(),
                    animal.getGender().getGenderName(),
                    animal.getCountry().getCountryName(),
                    animal.getDateOfEntry().toString()
            ))
            .collect(Collectors.toList());
    }

    public List<AnimalDTO> getAnimalsByFamilyAndType(String family, String type) {
        return animalRepository.findByFamilyFamilyNameAndTypeTypeName(family, type)
                .stream()
                .map(animal -> new AnimalDTO(
                        animal.getName(),
                        animal.getType().getTypeName(),
                        animal.getFamily().getFamilyName(),
                        animal.getGender().getGenderName(),
                        animal.getCountry().getCountryName(),
                        animal.getDateOfEntry().toString()
                ))
                .collect(Collectors.toList());
    }
    
}
