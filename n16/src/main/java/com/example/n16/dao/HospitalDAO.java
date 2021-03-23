package com.example.n16.dao;

import com.example.n16.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDAO extends JpaRepository<Hospital, Integer> {
}
