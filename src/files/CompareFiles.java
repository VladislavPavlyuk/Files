package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareFiles {
    private String path1;
    private String path2;

    public CompareFiles(){}

    public CompareFiles(String path1, String path2) {
        this.path1 = path1;
        this.path2 = path2;
    }

    public String getPath1() {
        return path1;
    }
    public void setPath1(String path1) {
        this.path1 = path1;
    }
    public String getPath2() {
        return path2;
    }
    public void setPath2(String path2) {
        this.path2 = path2;
    }

    public void compareFiles() {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(path1));
             BufferedReader reader2 = new BufferedReader(new FileReader(path2))) {

            String line1, line2;
            boolean filesAreEqual = true;

            while ((line1 = reader1.readLine()) != null & (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    System.out.println("Несовпадающие строки:");
                    System.out.println("Файл 1: " + line1);
                    System.out.println("Файл 2: " + line2);
                    filesAreEqual = false;
                }
            }

            if (filesAreEqual) {
                System.out.println("Файлы идентичны.");
            }

        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файлов: " + e.getMessage());
        }
    }
}

