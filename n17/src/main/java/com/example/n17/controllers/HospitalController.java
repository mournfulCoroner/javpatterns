package com.example.n17.controllers;

import com.example.n17.dto.HospitalDTO;
import com.example.n17.models.Hospital;
import com.example.n17.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/hospitals")
    public List<Hospital> getAll(){
        return hospitalService.getAll();
    }

    @DeleteMapping("/hospitals/{name}")
    public List<Hospital> delete(@PathVariable("name") String name){
        List<Hospital> list = hospitalService.getAll();
        for(Hospital p: list){
            if (p.getName().equalsIgnoreCase(name)) {
                hospitalService.delete(p);
                break;
            }
        }
        return hospitalService.getAll();
    }

    @PostMapping("/hospitals")
    public List<Hospital> create(@RequestBody Hospital hospital){
        hospitalService.add(hospital);
        return hospitalService.getAll();
    }

    @GetMapping("/hospitals/filter")
    public List<HospitalDTO> getFilter(@RequestParam(defaultValue = "") String name,
                                       @RequestParam(defaultValue = "") String address){
        List<HospitalDTO> patientDTOS = null;
        patientDTOS = hospitalService.filterHospitals(name, address);
        return patientDTOS;
    }
}
