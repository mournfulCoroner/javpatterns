package com.example.n21.services;

import com.example.n21.dao.HospitalDAO;
import com.example.n21.dao.PatientDAO;
import com.example.n21.dto.HospitalDTO;
import com.example.n21.models.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HospitalService {
    private final HospitalDAO hospitalDAO;
    private final PatientDAO patientDAO;

    private final EmailNotificationService emailNotificationService;

    @Autowired
    public HospitalService(HospitalDAO hospitalDAO, PatientDAO patientDAO, EmailNotificationService emailNotificationService) {
        this.hospitalDAO = hospitalDAO;
        this.patientDAO = patientDAO;
        this.emailNotificationService = emailNotificationService;
        log.info("Hospital construct");
    }

    @Transactional
    public List<Hospital> getAll(){
        log.info("Get all hospitals");
        return hospitalDAO.findAll(); }

    @Transactional
    public void delete(Hospital h){
        patientDAO.deleteAllByHospital(h);
        hospitalDAO.delete(h);
        log.info("Hospital was deleted");
    }

    @Transactional
    public void add(Hospital h){ hospitalDAO.save(h);
    log.info("Hospital was added");
        emailNotificationService.sendEmailNotification("Hospital " + h.getName() +
                 "has saved to db");}

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
        log.info("Hospitals are filtered");
        return hospitalDTOS;
    }
}
