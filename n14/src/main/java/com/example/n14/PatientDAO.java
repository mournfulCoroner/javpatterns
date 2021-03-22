package com.example.n14;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDAO {
    private List<Patient> patientList = new ArrayList<>();
    {
        Patient pat = new Patient();
        pat.setFirstName("Александра");
        pat.setLastName("Майская");
        patientList.add(pat);
    }

    public void add(Patient p){
        patientList.add(p);
    }

    public void delete(Patient p){
        patientList.remove(p);
    }

    public List<Patient> getAll(){
        return patientList;
    }

}
