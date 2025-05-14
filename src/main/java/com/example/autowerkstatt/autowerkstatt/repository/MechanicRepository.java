package com.example.autowerkstatt.autowerkstatt.repository;

import com.example.autowerkstatt.autowerkstatt.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
    // Поиск по части фамилии (например, для автокомплита)
    List<Mechanic> findByLastName(String lastName);

    Optional<Mechanic> findByEmail(String email);

    List<Mechanic> findBySpecialization(String specialization);
}
