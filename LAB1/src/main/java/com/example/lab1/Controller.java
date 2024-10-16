package com.example.lab1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textArea2;

    public void initialize() {
        runWorkFiles();
        readFileThread();
    }

    @FXML
    private void readFileThread(){
        ReadFile readFile = new ReadFile(this);
        readFile.start();
    }

    public void updateTextArea(String content) {
        Platform.runLater(() -> textArea.appendText(content));
    }

    @FXML
    private void runWorkFiles() {
        WorkFiles workFiles = new WorkFiles("File Thread", this);
        workFiles.start();
    }


    public void updateTextArea2(String content) {
        Platform.runLater(() -> textArea2.appendText(content));
    }

    private void writeFile() {
        Write write = new Write(this);
        write.start();
    }

    public void onSaveButtonClick() {
        writeFile();
    }

    public String getTextFromTextArea() {
        return textArea.getText();
    }
}