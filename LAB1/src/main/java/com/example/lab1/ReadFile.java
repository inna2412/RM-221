package com.example.lab1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile extends Thread {
    private final Controller controller;

    public ReadFile(Controller controller) {
        this.controller = controller;  // Передаем контроллер через конструктор
    }

    @Override
    public void run() {
        try( FileReader fr = new FileReader("E:\\UTM 4\\workspace\\file.txt")) {
           int c;
           StringBuilder content = new StringBuilder();
           while ((c = fr.read())!= -1){
                content.append((char)c);
            }
            controller.updateTextArea(content.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
