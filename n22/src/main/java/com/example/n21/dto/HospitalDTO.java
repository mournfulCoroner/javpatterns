package com.example.n21.dto;

import java.util.Set;

public class HospitalDTO {

    private int id;
    private String address;
    private String name;
    private Set<PatientDTO> patientDTOSet;

    public Set<PatientDTO> getPatientDTOSet() {
        return patientDTOSet;
    }

    public void setPatientDTOSet(Set<PatientDTO> patientDTOSet) {
        this.patientDTOSet = patientDTOSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
