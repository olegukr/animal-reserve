package org.factoriaf5.animal_reserve.controller;

import java.util.List;

import org.factoriaf5.animal_reserve.dto.AnimalDTO;
import org.factoriaf5.animal_reserve.repository.AnimalRepository;
import org.factoriaf5.animal_reserve.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @RestController
// @RequestMapping("/api/v1/public")
// public class AnimalController {


//     @Autowired
//     private AnimalRepository animalRepository;

//     @Autowired
//     private AnimalService animalService;

//     @GetMapping("/animals")
//     public ResponseEntity<?> getAllAnimals() {
//         System.out.println("GET /api/v1/public/animals called");
//         List<AnimalDTO> animalDTO = animalService.getAllAnimals();
//         return ResponseEntity.ok(animalDTO);
//     }
// }

// @RequestMapping("/api/v1/public")

@RestController
@RequestMapping("${api-endpoint}/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalService animalService;

    @GetMapping("/public/all")
    public ResponseEntity<?> getAllAnimals() {
        System.out.println("GET /api/v1/public/animals/all called");
        List<AnimalDTO> animalDTO = animalService.getAllAnimals();
        return ResponseEntity.ok(animalDTO);
    }

    @GetMapping("/public")
    public Page<AnimalDTO> getPaginatedAnimals(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return animalService.getPaginatedAnimals(page, size);
    }


    @GetMapping("/public/family")
    public Page<AnimalDTO> getAnimalsByFamily(
            @RequestParam String family,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return animalService.getAnimalsByFamily(family, page, size);
    }

    @GetMapping("/public/country")
    public List<AnimalDTO> getAnimalsByCountry(@RequestParam String country) {
        return animalService.getAnimalsByCountry(country);
    }

    @GetMapping("/public/family-and-type")
    public List<AnimalDTO> getAnimalsByFamilyAndType(
            @RequestParam String family,
            @RequestParam String type
    ) {
        return animalService.getAnimalsByFamilyAndType(family, type);
    }

    @GetMapping("/admin/count")
public ResponseEntity<String> getTotalAnimals() {
    long totalAnimals = animalService.getTotalAnimals();
    return ResponseEntity.ok(Long.toString(totalAnimals).trim());
}

    @GetMapping("/admin/name")
    public AnimalDTO getAnimalByName(@RequestParam String name) {
    return animalService.getAnimalByName(name);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable Long id) {
        try {
            AnimalDTO animalDTO = animalService.getAnimalById(id);
            return ResponseEntity.ok(animalDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/admin")
    public AnimalDTO addAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.addAnimal(animalDTO);
    }
    
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
        try {
            String message = animalService.deleteAnimalById(id);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateAnimal(@PathVariable Long id, @RequestBody AnimalDTO updatedAnimalDTO) {
        try {
            AnimalDTO updatedAnimal = animalService.updateAnimal(id, updatedAnimalDTO);
            return ResponseEntity.ok(updatedAnimal);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
