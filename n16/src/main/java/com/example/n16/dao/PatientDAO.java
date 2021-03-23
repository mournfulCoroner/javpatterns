package com.example.n16.dao;

        import com.example.n16.models.Patient;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer> {
}
