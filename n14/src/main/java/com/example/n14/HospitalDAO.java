package com.example.n14;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HospitalDAO {
    private List<Hospital> hospitalList = new ArrayList<>();
    {
        Hospital h = new Hospital();
        h.setAddress("ул. Майская 4");
        h.setName("Больница №6");
        hospitalList.add(h);
    }

    public void add(Hospital h){
        hospitalList.add(h);
    }

    public void delete(Hospital h){
        hospitalList.remove(h);
    }

    public List<Hospital> getAll(){
        return hospitalList;
    }
}
