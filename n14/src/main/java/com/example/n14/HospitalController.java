package com.example.n14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    private final HospitalDAO hospitalDAO;

    @Autowired
    public HospitalController(HospitalDAO hospitalDAO) {
        this.hospitalDAO = hospitalDAO;
    }

    @GetMapping("/hospitals")
    public List<Hospital> getAll(){
        return hospitalDAO.getAll();
    }

    @DeleteMapping("/hospitals/{name}")
    public List<Hospital> delete(@PathVariable("name") String name){
        List<Hospital> list = hospitalDAO.getAll();
        for(Hospital p: list){
            if (p.getName().equalsIgnoreCase(name)) {
                hospitalDAO.delete(p);
                break;
            }
        }
        return hospitalDAO.getAll();
    }

    @PostMapping("/hospitals")
    public List<Hospital> create(@RequestBody Hospital hospital){
        hospitalDAO.add(hospital);
        return hospitalDAO.getAll();
    }
}
