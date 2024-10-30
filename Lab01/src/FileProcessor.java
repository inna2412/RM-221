import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor extends Thread {
    private final String filePath;

    public FileProcessor(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        System.out.println("Обработка файла " + filePath + " начата.");
        processFile();
        System.out.println("Обработка файла завершена.");
    }

    private void processFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;
            int wordCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += line.split("\\s+").length;
            }

            System.out.println("Количество строк: " + lineCount);
            System.out.println("Количество слов: " + wordCount);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
