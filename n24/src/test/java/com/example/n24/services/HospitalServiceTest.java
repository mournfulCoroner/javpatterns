package com.example.n24.services;

import com.example.n24.dao.HospitalDAO;
import com.example.n24.dao.PatientDAO;
import com.example.n24.dto.HospitalDTO;
import com.example.n24.models.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

public class HospitalServiceTest {
    @Mock
    private PatientDAO patientDAO;
    @Mock
    private HospitalDAO hospitalDAO;

    @Captor
    ArgumentCaptor<Hospital> captor;

    @Test
    public void getAll() {
        Hospital h1 = new Hospital();
        Hospital h2 = new Hospital();

        h1.setName("Hospital1");
        h2.setName("Tu");


        Mockito.when(hospitalDAO.findAll()).thenReturn(List.of(h1, h2));

        HospitalService hospitalService = new HospitalService(hospitalDAO, patientDAO);
        hospitalService.add(h1);
        hospitalService.add(h2);
        Assertions.assertEquals(2, hospitalService.getAll().size());
        Assertions.assertEquals("Hospital1", hospitalService.getAll().get(0).getName());
    }

    @Test
    public void add() {
        Hospital h = new Hospital();
        h.setName("#1");

        HospitalService hospitalService = new HospitalService(hospitalDAO, patientDAO);
        hospitalService.add(h);
        Mockito.verify(hospitalDAO).save(captor.capture());
        Hospital captured = captor.getValue();
        Assertions.assertEquals("#1", captured.getName());
    }

    @Test
    public void filterPatients(){
        Hospital h1 = new Hospital();
        Hospital h2 = new Hospital();
        h1.setName("Tarara");
        h2.setAddress("Ratata");
        Mockito.when(hospitalDAO.filterByFields("Tarara","")).thenReturn(List.of(h1));
        Mockito.when(hospitalDAO.filterByFields("","Ratata")).thenReturn(List.of(h2));

        HospitalService hospitalService = new HospitalService(hospitalDAO, patientDAO);

        List<HospitalDTO> hospitals1 = hospitalService.filterHospitals("Tarara","");
        List<HospitalDTO> hospitals2 = hospitalService.filterHospitals("","Ratata");

        Assertions.assertEquals(1, hospitals1.size());
        Assertions.assertEquals(1, hospitals2.size());
        Assertions.assertEquals("Tarara", hospitals1.get(0).getName());
        Assertions.assertEquals("Ratata", hospitals2.get(0).getAddress());
    }

}
