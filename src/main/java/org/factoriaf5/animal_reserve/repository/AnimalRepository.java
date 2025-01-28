package org.factoriaf5.animal_reserve.repository;

import java.util.List;
import java.util.Optional;

import org.factoriaf5.animal_reserve.model.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Override
    long count();

    Page<Animal> findByFamilyFamilyName(String familyName, Pageable pageable);

    List<Animal> findByCountryCountryName(String countryName);

    List<Animal> findByFamilyFamilyNameAndTypeTypeName(String familyName, String typeName);

    Optional<Animal> findByName(String name);

    @SuppressWarnings("null")
    @Override
    boolean existsById(Long id);

    // List<Animal> findByFamilyFamilyNameIgnoreCaseAndTypeTypeNameIgnoreCase(String familyName, String typeName);

}
