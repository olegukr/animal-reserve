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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // public AnimalService(AnimalRepository animalRepository) {
    //     this.animalRepository = animalRepository;
    // }

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
            .map(Animal::toDTO);
    }

    public Page<AnimalDTO> getAnimalsByFamily(String family, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findByFamilyFamilyName(family, pageable)
            .map(Animal::toDTO);
    }

    public List<AnimalDTO> getAllAnimals() {
        return animalRepository.findAll()
            .stream()
            .map(Animal::toDTO)
            .collect(Collectors.toList());
    }

    public List<AnimalDTO> getAnimalsByCountry(String country) {
        return animalRepository.findByCountryCountryName(country)
            .stream()
            .map(Animal::toDTO)
            .collect(Collectors.toList());
    }

    public List<AnimalDTO> getAnimalsByFamilyAndType(String family, String type) {
        return (List<AnimalDTO>) animalRepository.findByFamily_FamilyNameAndType_TypeName(family, type)
            .stream()
            .map(Animal::toDTO)
            .collect(Collectors.toList());
    }

    public long getTotalAnimals() {
        return animalRepository.count();
    }

    public AnimalDTO getAnimalByName(String name) {
        Animal animal = animalRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Animal not found"));
        return animal.toDTO();
        }

    public AnimalDTO getAnimalById(Long id) {
        Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal not found"));
        return  animal.toDTO();
    }

    public AnimalDTO addAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal();
    
        animal.setName(animalDTO.name());
        animal.setType(animalTypeRepository.findByTypeName(animalDTO.type())
            .orElseThrow(() -> new RuntimeException("Animal type not found")));
        animal.setFamilyName(animalFamilyRepository.findByFamilyName(animalDTO.family())
            .orElseThrow(() -> new RuntimeException("Animal family not found")));
        animal.setGender(genderRepository.findByGenderName(animalDTO.gender())
            .orElseThrow(() -> new RuntimeException("Gender not found")));
        animal.setCountry(countryRepository.findByCountryName(animalDTO.country())
            .orElseThrow(() -> new RuntimeException("Country not found")));
        animal.setDateOfEntry(java.sql.Date.valueOf(animalDTO.dateOfEntry()));
    
        Animal savedAnimal = animalRepository.save(animal);
    
        return savedAnimal.toDTO();
    }

    public String deleteAnimalById(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Animal with ID " + id + " does not exist.");
        }

        animalRepository.deleteById(id);
        return "Animal with ID " + id + " has been successfully deleted.";
    }

    public AnimalDTO updateAnimal(Long id, AnimalDTO updatedAnimalDTO) {
        
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal with ID " + id + " does not exist."));
    
        animal.setName(updatedAnimalDTO.name());
        
        animal.setType(animalTypeRepository.findByTypeName(updatedAnimalDTO.type())
                .orElseThrow(() -> new RuntimeException("Animal type " + updatedAnimalDTO.type() + " not found.")));
    
        animal.setFamilyName(animalFamilyRepository.findByFamilyName(updatedAnimalDTO.family())
                .orElseThrow(() -> new RuntimeException("Animal family " + updatedAnimalDTO.family() + " not found.")));
    
        animal.setGender(genderRepository.findByGenderName(updatedAnimalDTO.gender())
                .orElseThrow(() -> new RuntimeException("Gender " + updatedAnimalDTO.gender() + " not found.")));
    
        animal.setCountry(countryRepository.findByCountryName(updatedAnimalDTO.country())
                .orElseThrow(() -> new RuntimeException("Country " + updatedAnimalDTO.country() + " not found.")));
    
        animal.setDateOfEntry(java.sql.Date.valueOf(updatedAnimalDTO.dateOfEntry()));
    
        Animal updatedAnimal = animalRepository.save(animal);
    
        return updatedAnimal.toDTO();
    }
    

}
