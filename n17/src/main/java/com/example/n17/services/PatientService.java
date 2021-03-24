package com.example.n17.services;

import com.example.n17.dao.HospitalDAO;
import com.example.n17.dao.PatientDAO;
import com.example.n17.dao.PatientFilterDAO;
import com.example.n17.dto.PatientDTO;
import com.example.n17.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientDAO patientDAO;
    private final HospitalDAO hospitalDAO;
    private final PatientFilterDAO patientFilterDAO;

    @Autowired
    public PatientService(PatientDAO patientDAO, HospitalDAO hospitalDAO, PatientFilterDAO patientFilterDAO) {
        this.patientDAO = patientDAO;
        this.hospitalDAO = hospitalDAO;
        this.patientFilterDAO = patientFilterDAO;
    }

    public void add(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findByName(patientDTO.getHospitalName()));
        patientDAO.save(patient);
    }

    public void delete(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findByName(patientDTO.getHospitalName()));
        patientDAO.delete(patient);
    }

    public List<PatientDTO> getAll(){
        List<PatientDTO> patients = new ArrayList<>();
        for(Patient p: patientDAO.findAll()){
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setId(p.getId());
            patientDTO.setFirstName(p.getFirstName());
            patientDTO.setLastName(p.getLastName());
            if(p.getHospital() != null) patientDTO.setHospitalName(p.getHospital().getName());
            patients.add(patientDTO);
        }
        return patients;
    }

    public List<PatientDTO> filterPatients(String firstName, String lastName, String hospitalName){
        return patientFilterDAO.filterByFields(firstName, lastName, hospitalName);
    }
}
