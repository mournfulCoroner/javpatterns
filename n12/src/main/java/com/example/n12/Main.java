package com.example.n12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Main {
    private FileController fileController;

    @Autowired
    public Main(FileController fileController){
        this.fileController = fileController;
    }

}
