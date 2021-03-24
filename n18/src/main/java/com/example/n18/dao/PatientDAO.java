package com.example.n18.dao;

        import com.example.n18.models.Hospital;

        import com.example.n18.models.Patient;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;
        import java.util.List;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer> {
        @Transactional
        void deleteAllByHospital(Hospital hospital);

        @Query(value = "select patient.* from patient left join hospital on hospital.id = patient.hospital_id " +
                "where ('' = :firstName or first_name = :firstName) and " +
                "('' = :lastName or last_name = :lastName) and " +
                "('' = :hospitalName or hospital.name = :hospitalName or hospital_id is null)", nativeQuery = true)
        List<Patient> filterByFields(String firstName, String lastName, String hospitalName);
}
