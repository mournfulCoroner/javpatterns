package com.example.n24.services;

import com.example.n24.dao.HospitalDAO;
import com.example.n24.dao.PatientDAO;
import com.example.n24.dto.HospitalDTO;
import com.example.n24.models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public List<Hospital> getAll(){
        return hospitalDAO.findAll(); }

    @Transactional
    public void delete(Hospital h){
        patientDAO.deleteAllByHospital(h);
        hospitalDAO.delete(h);
    }

    @Transactional
    public void add(Hospital h){ hospitalDAO.save(h);}

    @Transactional
    public List<HospitalDTO> filterHospitals(String name, String address){
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(Hospital h: hospitalDAO.filterByFields(name, address)){
            HospitalDTO hospitalDTO = new HospitalDTO();
            hospitalDTO.setName(h.getName());
            hospitalDTO.setId(h.getId());
            hospitalDTO.setAddress(h.getAddress());
            hospitalDTOS.add(hospitalDTO);
        }
        return hospitalDTOS;
    }
}
