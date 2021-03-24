package com.example.n18.services;

import com.example.n18.dao.HospitalDAO;
import com.example.n18.dao.PatientDAO;
import com.example.n18.dto.PatientDTO;
import com.example.n18.models.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PatientService {
    private final PatientDAO patientDAO;
    private final HospitalDAO hospitalDAO;

    @Autowired
    public PatientService(PatientDAO patientDAO, HospitalDAO hospitalDAO) {
        this.patientDAO = patientDAO;
        this.hospitalDAO = hospitalDAO;
        log.info("Patient's construct");
    }

    public void add(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findByName(patientDTO.getHospitalName()));
        patientDAO.save(patient);
        log.info("Patient was added");
    }

    public void delete(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findByName(patientDTO.getHospitalName()));
        patientDAO.delete(patient);
        log.info("Patient was deleted");
    }

    private List<PatientDTO> transferToDTO(List<Patient> plist){
        List<PatientDTO> patients = new ArrayList<>();
        for(Patient p: plist){
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setId(p.getId());
            patientDTO.setFirstName(p.getFirstName());
            patientDTO.setLastName(p.getLastName());
            if(p.getHospital() != null) patientDTO.setHospitalName(p.getHospital().getName());
            patients.add(patientDTO);
        }
        log.info("List was transfered to DTO");
        return patients;
    }

    public List<PatientDTO> getAll(){
        log.info("Get all patients");
        return transferToDTO(patientDAO.findAll());
    }

    public List<PatientDTO> filterPatients(String firstName, String lastName, String hospitalName){
        log.info("Filter patients");
        return transferToDTO(patientDAO.filterByFields(firstName, lastName, hospitalName));
    }
}
