package com.example.n21.dao;

import com.example.n21.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalDAO extends JpaRepository<Hospital, Integer> {
    Hospital findByName(String name);

    @Query(value = "select hospital.* from hospital " +
            "where ('' = :name or name = :name) and " +
            "('' = :address or address = :address)" , nativeQuery = true)
    List<Hospital> filterByFields(String name, String address);
}
