package com.example.n17.dao;

import com.example.n17.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDAO extends JpaRepository<Hospital, Integer> {
    Hospital findByName(String name);
}
