package org.factoriaf5.animal_reserve.service;

import java.util.List;
import java.util.stream.Collectors;

import org.factoriaf5.animal_reserve.dto.AnimalDTO;
import org.factoriaf5.animal_reserve.model.Animal;
import org.factoriaf5.animal_reserve.repository.AnimalFamilyRepository;
import org.factoriaf5.animal_reserve.repository.AnimalRepository;
import org.factoriaf5.animal_reserve.repository.AnimalTypeRepository;
import org.factoriaf5.animal_reserve.repository.CountryRepository;
import org.factoriaf5.animal_reserve.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @Autowired
    private AnimalFamilyRepository animalFamilyRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Page<AnimalDTO> getPaginatedAnimals(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findAll(pageable)
            .map(animal -> new AnimalDTO(
            animal.getId(),
            animal.getName(),
            animal.getType().getTypeName(),
            animal.getFamily().getFamilyName(),
            animal.getGender().getGenderName(),
            animal.getCountry().getCountryName(),
            animal.getDateOfEntry().toString()));
    }

    public Page<AnimalDTO> getAnimalsByFamily(String family, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findByFamilyFamilyName(family, pageable)
            .map(animal -> new AnimalDTO(
            animal.getId(),
            animal.getName(),
            animal.getType().getTypeName(),
            animal.getFamily().getFamilyName(),
            animal.getGender().getGenderName(),
            animal.getCountry().getCountryName(),
            animal.getDateOfEntry().toString()));
    }

    public List<AnimalDTO> getAnimalsByCountry(String country) {
        return animalRepository.findByCountryCountryName(country)
            .stream()
            .map(animal -> new AnimalDTO(
            animal.getId(),
            animal.getName(),
            animal.getType().getTypeName(),
            animal.getFamily().getFamilyName(),
            animal.getGender().getGenderName(),
            animal.getCountry().getCountryName(),
            animal.getDateOfEntry().toString()))
            .collect(Collectors.toList());
    }

    public List<AnimalDTO> getAnimalsByFamilyAndType(String family, String type) {
        return animalRepository.findByFamilyFamilyNameAndTypeTypeName(family, type)
        // return animalRepository.findByFamilyFamilyNameIgnoreCaseAndTypeTypeNameIgnoreCase(family, type)
            .stream()
            .map(animal -> new AnimalDTO(
            animal.getId(),
            animal.getName(),
            animal.getType().getTypeName(),
            animal.getFamily().getFamilyName(),
            animal.getGender().getGenderName(),
            animal.getCountry().getCountryName(),
            animal.getDateOfEntry().toString()))
            .collect(Collectors.toList());
    }

    public long getTotalAnimals() {
        return animalRepository.count();
    }

    public AnimalDTO getAnimalByName(String name) {
        Animal animal = animalRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Animal not found"));
        return new AnimalDTO(
            animal.getId(),
            animal.getName(),
            animal.getType().getTypeName(),
            animal.getFamily().getFamilyName(),
            animal.getGender().getGenderName(),
            animal.getCountry().getCountryName(),
            animal.getDateOfEntry().toString()
            );
        }

    public AnimalDTO addAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setName(animalDTO.getName());
        animal.setType(animalTypeRepository.findByTypeName(animalDTO.getType())
            .orElseThrow(() -> new RuntimeException("Animal type not found")));
        animal.setFamily(animalFamilyRepository.findByFamilyName(animalDTO.getFamily())
            .orElseThrow(() -> new RuntimeException("Animal family not found")));
        animal.setGender(genderRepository.findByGenderName(animalDTO.getGender())
            .orElseThrow(() -> new RuntimeException("Gender not found")));
        animal.setCountry(countryRepository.findByCountryName(animalDTO.getCountry())
            .orElseThrow(() -> new RuntimeException("Country not found")));
        animal.setDateOfEntry(java.sql.Date.valueOf(animalDTO.getDateOfEntry()));
    
        Animal savedAnimal = animalRepository.save(animal);
        return new AnimalDTO(
            savedAnimal.getId(),
            savedAnimal.getName(),
            savedAnimal.getType().getTypeName(),
            savedAnimal.getFamily().getFamilyName(),
            savedAnimal.getGender().getGenderName(),
            savedAnimal.getCountry().getCountryName(),
            savedAnimal.getDateOfEntry().toString()
        );
    }

    public String deleteAnimalById(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Animal with ID " + id + " does not exist.");
        }

        animalRepository.deleteById(id);
        return "Animal with ID " + id + " has been successfully deleted.";
    }

}
