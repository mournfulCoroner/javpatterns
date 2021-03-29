package com.example.n24.services;

import com.example.n24.dao.HospitalDAO;
import com.example.n24.dao.PatientDAO;
import com.example.n24.dto.PatientDTO;
import com.example.n24.models.Hospital;
import com.example.n24.models.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @Mock
    private PatientDAO patientDAO;
    @Mock
    private HospitalDAO hospitalDAO;

    @Captor
    ArgumentCaptor<Patient> captor;

    @Test
    public void getAll() {
        Patient p1 = new Patient();
        Patient p2 = new Patient();

        p1.setFirstName("Lil");
        p1.setLastName("Tu");

        p2.setFirstName("Lily");
        p2.setLastName("Tur");

        Mockito.when(patientDAO.findAll()).thenReturn(List.of(p1, p2));

        PatientService patientService = new PatientService(patientDAO, hospitalDAO);

        Assertions.assertEquals(2, patientService.getAll().size());
        Assertions.assertEquals("Lil", patientService.getAll().get(0).getFirstName());
    }

    @Test
    public void add() {
        Hospital h = new Hospital();
        h.setName("Tamer");

        PatientDTO p = new PatientDTO();
        p.setFirstName("Miu");
        p.setHospitalName("Tamer");

        Mockito.when(hospitalDAO.findByName(h.getName())).thenReturn(h);
        PatientService patientService = new PatientService(patientDAO, hospitalDAO);
        patientService.add(p);
        Mockito.verify(patientDAO).save(captor.capture());
        Patient captured = captor.getValue();
        Assertions.assertEquals("Miu", captured.getFirstName());
    }

    @Test
    public void filterPatients(){
        Patient p1 = new Patient();
        Patient p2 = new Patient();
        p1.setFirstName("Last");
        p2.setLastName("First");
        Mockito.when(patientDAO.filterByFields("","First","")).thenReturn(List.of(p2));
        Mockito.when(patientDAO.filterByFields("Last","","")).thenReturn(List.of(p1));

        PatientService patientService = new PatientService(patientDAO, hospitalDAO);

        List<PatientDTO> patients1 = patientService.filterPatients("Last", "", "");
        List<PatientDTO> patients2 = patientService.filterPatients("", "First", "");

        Assertions.assertEquals(1, patients1.size());
        Assertions.assertEquals(1, patients2.size());
        Assertions.assertEquals("Last", patients1.get(0).getFirstName());
        Assertions.assertEquals("First", patients2.get(0).getLastName());
    }

}
