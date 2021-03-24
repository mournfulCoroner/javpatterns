package com.example.n17.services;

import com.example.n17.dao.HospitalDAO;
import com.example.n17.dao.HospitalFilterDAO;
import com.example.n17.dao.PatientDAO;
import com.example.n17.dto.HospitalDTO;
import com.example.n17.models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    private final HospitalDAO hospitalDAO;
    private final PatientDAO patientDAO;
    private final HospitalFilterDAO hospitalFilterDAO;

    @Autowired
    public HospitalService(HospitalDAO hospitalDAO, PatientDAO patientDAO, HospitalFilterDAO hospitalFilterDAO) {
        this.hospitalDAO = hospitalDAO;
        this.patientDAO = patientDAO;
        this.hospitalFilterDAO = hospitalFilterDAO;
    }

    public List<Hospital> getAll(){
        return hospitalDAO.findAll(); }

    public void delete(Hospital h){
        patientDAO.deleteAllByHospital(h);
        hospitalDAO.delete(h);
    }

    public void add(Hospital h){ hospitalDAO.save(h);}

    public List<HospitalDTO> filterHospitals(String name, String address){
        return hospitalFilterDAO.filterByFields(name, address);
    }
}
