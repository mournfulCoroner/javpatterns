package com.example.n15.dao;

import com.example.n15.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer> {
}
