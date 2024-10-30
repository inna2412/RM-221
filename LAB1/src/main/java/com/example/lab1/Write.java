package com.example.lab1;
import java.io.FileWriter;
import java.io.IOException;

public class Write extends Thread {
    private final Controller controller;

    public Write(Controller controller) {
        this.controller = controller;  // Передаем контроллер через конструктор
    }

    @Override
    public void run() {
        saveTextToFile();
    }

    public void saveTextToFile() {
        String content = controller.getTextFromTextArea(); // Получаем текст из textArea
        try (FileWriter writer = new FileWriter("E:\\UTM 4\\workspace\\file.txt", false)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
