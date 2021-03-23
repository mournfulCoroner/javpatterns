package com.example.n16.dao;

        import com.example.n16.models.Hospital;

        import com.example.n16.models.Patient;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer> {
        @Transactional
        void deleteAllByHospital(Hospital hospital);
}
