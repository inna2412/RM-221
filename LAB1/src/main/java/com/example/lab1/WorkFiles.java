package com.example.lab1;

import java.io.File;
import java.io.FileReader;

public class WorkFiles extends Thread {

    private final Controller controller;

    // Конструктор получает контроллер
    WorkFiles(String name, Controller controller) {
        super(name);
        this.controller = controller;
    }

@Override
    public void run() {
        File myFile = new File("E:\\UTM 4\\workspace\\file.txt");
    StringBuilder output = new StringBuilder();
    output.append("File is: ").append(myFile.getName()).append("\n");
    output.append("Parent folder: ").append(myFile.getParent()).append("\n");
    output.append(exist(myFile)).append("\n");
    output.append("File size: ").append(myFile.length()).append(" ch.\n");
    output.append(read(myFile)).append("\n");
    output.append(canWrit(myFile)).append("\n");

    controller.updateTextArea2(output.toString());

    }

    public String exist(File file){
        if(file.exists()){
            return "File exists";
        }
        else {
            return "File not found";
        }
    }

    public String read(File file){
        if(file.canRead()){
            return "File can be read!";
        }
        else {
            return "File is not readable";
        }
    }

    public String canWrit(File file){
        if(file.canWrite()){
            return "File can be written!";
        }
        else return "File is not writable";
    }
}
