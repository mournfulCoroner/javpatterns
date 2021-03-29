package com.example.n24.services;

import com.example.n24.dao.HospitalDAO;
import com.example.n24.dao.PatientDAO;
import com.example.n24.dto.PatientDTO;
import com.example.n24.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void add(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findByName(patientDTO.getHospitalName()));
        patientDAO.save(patient);

    }

    @Transactional
    public void delete(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setHospital(hospitalDAO.findByName(patientDTO.getHospitalName()));
        patientDAO.delete(patient);
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
        return patients;
    }

    @Transactional
    public List<PatientDTO> getAll(){
        return transferToDTO(patientDAO.findAll());
    }

    @Transactional
    public List<PatientDTO> filterPatients(String firstName, String lastName, String hospitalName){
        return transferToDTO(patientDAO.filterByFields(firstName, lastName, hospitalName));
    }
}
