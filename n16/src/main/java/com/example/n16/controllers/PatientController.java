package com.example.n16.controllers;

import com.example.n16.models.Patient;
import com.example.n16.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getAll(){
        return patientService.getAll();
    }

    @DeleteMapping("/patients/{name}")
    public List<Patient> delete(@PathVariable("name") String name){
        List<Patient> list = patientService.getAll();
        for(Patient p: list){
            if (p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)) {
                patientService.delete(p);
                break;
            }
        }
        return patientService.getAll();
    }

    @PostMapping("/patients")
    public List<Patient> create(@RequestBody Patient patient){
        patientService.add(patient);
        return patientService.getAll();
    }
}
