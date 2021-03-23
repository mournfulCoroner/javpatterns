package com.example.n16.services;

import com.example.n16.dao.HospitalDAO;
import com.example.n16.dao.PatientDAO;
import com.example.n16.dto.PatientDTO;
import com.example.n16.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientDAO patientDAO;
    private final HospitalDAO hospitalDAO;

    @Autowired
    public PatientService(PatientDAO patientDAO, HospitalDAO hospitalDAO) {
        this.patientDAO = patientDAO;
        this.hospitalDAO = hospitalDAO;
    }

    public void add(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findById(patientDTO.getHospitalId()).orElse(null));
        patientDAO.save(patient);
    }

    public void delete(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findById(patientDTO.getHospitalId()).orElse(null));
        patientDAO.delete(patient);
    }

    public List<PatientDTO> getAll(){
        List<PatientDTO> patients = new ArrayList<>();
        for(Patient p: patientDAO.findAll()){
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setId(p.getId());
            patientDTO.setFirstName(p.getFirstName());
            patientDTO.setLastName(p.getLastName());
            if(p.getHospital() != null) patientDTO.setHospitalId(p.getHospital().getId());
            patients.add(patientDTO);
        }
        return patients;
    }
}
