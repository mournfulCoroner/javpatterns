package com.example.n12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Component
public class FileController {

    @Value("${file.input}")
    private String inputFile;
    @Value("${file.output}")
    private String outputFile;

    public String hash(File f){
        StringBuilder builder = new StringBuilder();
        try {
            Scanner fileReader = new Scanner(f);
            while (fileReader.hasNext()){
                builder.append(fileReader.next().hashCode()).append(" ");
            }
            fileReader.close();
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
        return builder.toString();
    }

    @PostConstruct
    public void init() {
        File file1 = new File(inputFile);
        File file2 = new File(outputFile);
        FileWriter writer;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            writer = new FileWriter(file2, false);
            if (file1.exists() && file1.isFile()) {
                String hashText = hash(file1);
                writer.write(hashText);
                System.out.println(hashText);
            }
            else {
                writer.write("null");
                System.out.println("null");
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    @PreDestroy
    public void crush(){
        File file1 = new File(inputFile);
        if(file1.exists() && file1.isFile()) file1.delete();
    }
}
