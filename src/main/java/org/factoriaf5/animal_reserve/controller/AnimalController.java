package org.factoriaf5.animal_reserve.controller;

import java.util.List;

import org.factoriaf5.animal_reserve.dto.AnimalDTO;
import org.factoriaf5.animal_reserve.repository.AnimalRepository;
import org.factoriaf5.animal_reserve.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${api-endpoint}/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public Page<AnimalDTO> getPaginatedAnimals(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return animalService.getPaginatedAnimals(page, size);
    }

    @GetMapping("/family")
    public Page<AnimalDTO> getAnimalsByFamily(
            @RequestParam String family,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return animalService.getAnimalsByFamily(family, page, size);
    }

    @GetMapping("/country")
    public List<AnimalDTO> getAnimalsByCountry(@RequestParam String country) {
        return animalService.getAnimalsByCountry(country);
    }

    @GetMapping("/family-and-type")
    public List<AnimalDTO> getAnimalsByFamilyAndType(
            @RequestParam String family,
            @RequestParam String type
    ) {
        return animalService.getAnimalsByFamilyAndType(family, type);
    }

    @GetMapping("/count")
    public long getTotalAnimals() {
    return animalService.getTotalAnimals();
    }

    @GetMapping("/name")
    public AnimalDTO getAnimalByName(@RequestParam String name) {
    return animalService.getAnimalByName(name);
    }

    @PostMapping
    public AnimalDTO addAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.addAnimal(animalDTO);
    }
    

}
