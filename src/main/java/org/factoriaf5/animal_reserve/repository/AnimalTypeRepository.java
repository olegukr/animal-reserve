package org.factoriaf5.animal_reserve.repository;

import java.util.Optional;

import org.factoriaf5.animal_reserve.model.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {
    Optional<AnimalType> findByTypeName(String typeName);
}

