package org.factoriaf5.animal_reserve.repository;

import java.util.List;

import org.factoriaf5.animal_reserve.model.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Page<Animal> findByFamilyFamilyName(String familyName, Pageable pageable);

    List<Animal> findByCountryCountryName(String countryName);

    List<Animal> findByFamilyFamilyNameAndTypeTypeName(String familyName, String typeName);

    // List<Animal> findByFamilyFamilyNameIgnoreCaseAndTypeTypeNameIgnoreCase(String familyName, String typeName);

}
