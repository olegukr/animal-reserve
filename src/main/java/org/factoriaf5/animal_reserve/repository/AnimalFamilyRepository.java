package org.factoriaf5.animal_reserve.repository;

import java.util.Optional;

import org.factoriaf5.animal_reserve.model.AnimalFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalFamilyRepository extends JpaRepository<AnimalFamily, Long> {
    // Find animal family by name
    Optional<AnimalFamily> findByFamilyName(String familyName);
}

