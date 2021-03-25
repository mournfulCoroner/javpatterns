package com.example.n21.services;

import com.example.n21.dao.HospitalDAO;
import com.example.n21.dao.PatientDAO;
import com.example.n21.models.Hospital;
import com.example.n21.models.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SchedulerService {
    @Value("${folder.data.path}")
    private String folderPath;

    private final HospitalDAO hospitalDAO;
    private final PatientDAO patientDAO;

    @Autowired
    public SchedulerService(HospitalDAO hospitalDAO, PatientDAO patientDAO) {
        this.hospitalDAO = hospitalDAO;
        this.patientDAO = patientDAO;
    }

    @Scheduled(fixedRate = 1800000)
    public void saveDBInfo(){
        log.info("Start scheduled method");
        File file = new File(folderPath);
        PrintWriter writer = null;
        List<File> fileList = Arrays.asList(file.listFiles());
        if(!fileList.isEmpty()) {
            for (File f : fileList)
                if (f.isFile()) f.delete();
        }
        StringBuilder sb = new StringBuilder();
        for(Patient p: patientDAO.findAll()){
            sb.append(p.toString()).append("\n");
        }

        try{
            writer = new PrintWriter(folderPath, "UTF-8");
            writer.print(sb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        sb.setLength(0);
        for(Hospital h: hospitalDAO.findAll()){
            sb.append(h.toString()).append("\n");
        }
        writer.print(sb.toString());
        writer.close();
    }
}
