package com.longbow.doctor_service.repository;

import com.longbow.doctor_service.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Optional<Doctor> findByEmail(String email);
}
