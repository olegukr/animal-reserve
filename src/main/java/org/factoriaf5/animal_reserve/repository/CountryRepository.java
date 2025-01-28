package org.factoriaf5.animal_reserve.repository;

import java.util.Optional;

import org.factoriaf5.animal_reserve.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByCountryName(String countryName);
}

