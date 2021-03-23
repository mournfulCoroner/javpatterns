package com.example.n16.services;

import com.example.n16.dao.HospitalDAO;
import com.example.n16.dao.PatientDAO;
import com.example.n16.dto.HospitalDTO;
import com.example.n16.models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {
    private final HospitalDAO hospitalDAO;
    private final PatientDAO patientDAO;

    @Autowired
    public HospitalService(HospitalDAO hospitalDAO, PatientDAO patientDAO) {
        this.hospitalDAO = hospitalDAO;
        this.patientDAO = patientDAO;
    }

    public List<Hospital> getAll(){
        return hospitalDAO.findAll(); }

    public void delete(Hospital h){
        patientDAO.deleteAllByHospital(h);
        hospitalDAO.delete(h);
    }

    public void add(Hospital h){ hospitalDAO.save(h);}
}
