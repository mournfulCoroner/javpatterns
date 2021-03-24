package com.example.n18.controllers;

import com.example.n18.dto.PatientDTO;
import com.example.n18.models.Patient;
import com.example.n18.services.PatientService;
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
    public List<PatientDTO> getAll(){
        return patientService.getAll();
    }

    @DeleteMapping("/patients/{name}")
    public List<PatientDTO> delete(@PathVariable("name") String name){
        List<PatientDTO> list = patientService.getAll();
        for(PatientDTO p: list){
            if (p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)) {
                patientService.delete(p);
                break;
            }
        }
        return patientService.getAll();
    }

    @PostMapping("/patients")
    public List<PatientDTO> create(@RequestBody PatientDTO patientDTO){
        patientService.add(patientDTO);
        return patientService.getAll();
    }

    @GetMapping("/patients/filter")
    public List<PatientDTO> getFilter(@RequestParam(defaultValue = "") String firstName,
                                      @RequestParam(defaultValue = "") String lastName,
                                      @RequestParam(defaultValue = "") String hospitalName){
        List<PatientDTO> patientDTOS = null;
        patientDTOS = patientService.filterPatients(firstName, lastName, hospitalName);
        return patientDTOS;
    }
}
