package com.example.n14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    private final PatientDAO patientDAO;

    @Autowired
    public PatientController(PatientDAO patientDAO){
        this.patientDAO = patientDAO;
    }

    @GetMapping("/patients")
    public List<Patient> getAll(){
        return patientDAO.getAll();
    }

    @DeleteMapping("/patients/{name}")
    public List<Patient> getAll(@PathVariable("name") String name){
        List<Patient> list = patientDAO.getAll();
        for(Patient p: list){
            if (p.getFirstName() == name || p.getLastName() == name) {
                patientDAO.delete(p);
                break;
            }
        }
        return patientDAO.getAll();
    }

    @PostMapping("/patients")
    public List<Patient> create(@RequestBody Patient patient){
        patientDAO.add(patient);
        return patientDAO.getAll();
    }
}
