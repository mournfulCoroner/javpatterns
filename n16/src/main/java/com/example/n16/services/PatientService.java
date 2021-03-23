package com.example.n16.services;

import com.example.n16.dao.PatientDAO;
import com.example.n16.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientDAO patientDAO;

    @Autowired
    public PatientService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public void add(Patient p){
        patientDAO.save(p);
    }

    public void delete(Patient p){
        patientDAO.delete(p);
    }

    public List<Patient> getAll(){
        return patientDAO.findAll();
    }
}
