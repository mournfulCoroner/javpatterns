package com.example.n18.services;

import com.example.n18.dao.HospitalDAO;
import com.example.n18.dao.PatientDAO;
import com.example.n18.dto.HospitalDTO;
import com.example.n18.models.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HospitalService {
    private final HospitalDAO hospitalDAO;
    private final PatientDAO patientDAO;

    @Autowired
    public HospitalService(HospitalDAO hospitalDAO, PatientDAO patientDAO) {
        this.hospitalDAO = hospitalDAO;
        this.patientDAO = patientDAO;
        log.info("Hospital construct");
    }

    public List<Hospital> getAll(){
        log.info("Get all hospitals");
        return hospitalDAO.findAll(); }

    public void delete(Hospital h){
        patientDAO.deleteAllByHospital(h);
        hospitalDAO.delete(h);
        log.info("Hospital was deleted");
    }

    public void add(Hospital h){ hospitalDAO.save(h);
    log.info("Hospital was added");}

    public List<HospitalDTO> filterHospitals(String name, String address){
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(Hospital h: hospitalDAO.filterByFields(name, address)){
            HospitalDTO hospitalDTO = new HospitalDTO();
            hospitalDTO.setName(h.getName());
            hospitalDTO.setId(h.getId());
            hospitalDTO.setAddress(h.getAddress());
            hospitalDTOS.add(hospitalDTO);
        }
        log.info("Hospitals are filtered");
        return hospitalDTOS;
    }
}
