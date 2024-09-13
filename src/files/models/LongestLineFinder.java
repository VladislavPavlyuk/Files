package files.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestLineFinder {

    private String filePath;

    public LongestLineFinder(String filePath) {
        this.filePath = filePath;
    }
    public LongestLineFinder(){}

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void findLongestLine(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String longestLine = "";
            String currentLine;
            int maxLength = 0;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.length() > maxLength) {
                    maxLength = currentLine.length();
                    longestLine = currentLine;
                }
            }

            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Сама строка: " + longestLine);

        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }
    }
}


