package com.example.n16.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Patient> patientsSet;

    public Set<Patient> getPatientsSet() {
        return patientsSet;
    }

    public void setPatientsSet(Set<Patient> patientsSet) {
        this.patientsSet = patientsSet;
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

    public void addPatient(Patient patient){
        patientsSet.add(patient);
    }

    public void removePatient(Patient patient){
        patientsSet.remove(patient);
    }
}
