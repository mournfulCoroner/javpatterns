package com.example.n16.services;

import com.example.n16.dao.HospitalDAO;
import com.example.n16.models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    private final HospitalDAO hospitalDAO;

    @Autowired
    public HospitalService(HospitalDAO hospitalDAO) {
        this.hospitalDAO = hospitalDAO;
    }

    public List<Hospital> getAll(){ return hospitalDAO.findAll(); }

    public void delete(Hospital h){ hospitalDAO.delete(h);}

    public void add(Hospital h){ hospitalDAO.save(h);}
}
