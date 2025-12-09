package files.services;

import files.interfaces.IFileComparator;

import java.io.IOException;
import java.util.List;

public class FileComparisonService {
    private final IFileComparator comparator;

    public FileComparisonService(IFileComparator comparator) {
        this.comparator = comparator;
    }

    public void compareFiles(String filePath1, String filePath2) throws IOException {
        List<String> differences = comparator.compare(filePath1, filePath2);
        
        if (differences.isEmpty()) {
            System.out.println("Файлы идентичны.");
        } else {
            System.out.println("Несовпадающие строки:");
            for (String diff : differences) {
                // Формат: "Line N: File1='...', File2='...'"
                int colonIndex = diff.indexOf(':');
                if (colonIndex > 0) {
                    String lineInfo = diff.substring(0, colonIndex);
                    String fileInfo = diff.substring(colonIndex + 2);
                    
                    int file1Start = fileInfo.indexOf("File1='") + 7;
                    int file1End = fileInfo.indexOf("', File2='");
                    int file2Start = fileInfo.indexOf("File2='") + 7;
                    int file2End = fileInfo.lastIndexOf("'");
                    
                    if (file1Start > 6 && file1End > file1Start && file2Start > file1End && file2End > file2Start) {
                        String line1 = fileInfo.substring(file1Start, file1End);
                        String line2 = fileInfo.substring(file2Start, file2End);
                        System.out.println(lineInfo + ":");
                        System.out.println("Файл 1: " + line1);
                        System.out.println("Файл 2: " + line2);
                    }
                }
            }
        }
    }
}

