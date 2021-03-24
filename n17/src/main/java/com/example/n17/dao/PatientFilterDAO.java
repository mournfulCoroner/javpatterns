package com.example.n17.dao;

import com.example.n17.dto.PatientDTO;
import com.example.n17.models.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientFilterDAO {
    @PersistenceContext
    EntityManager em;

    public List<PatientDTO> filterByFields(String firstName, String lastName, String hospitalName){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);

        Root<Patient> proot = cq.from(Patient.class);
        List<Predicate> preds = new ArrayList<>();

        if(hospitalName != null && !hospitalName.isEmpty()) {
            preds.add(cb.equal(proot.get("hospital").get("name"), hospitalName));
        }
        if(firstName != null && !firstName.isEmpty()) {
            preds.add(cb.equal(proot.get("firstName"), firstName));
        }
        if(lastName != null && !lastName.isEmpty()) {
            preds.add(cb.equal(proot.get("lastName"), lastName));
        }

        cq.where(preds.toArray(new Predicate[0]));
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for(Patient p: em.createQuery(cq).getResultList()){
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setId(p.getId());
            patientDTO.setFirstName(p.getFirstName());
            patientDTO.setLastName(p.getLastName());
            if(p.getHospital() != null) patientDTO.setHospitalName(p.getHospital().getName());
            patientDTOS.add(patientDTO);
        }
        return patientDTOS;
    }
}
