package files.service;

import files.models.CompareFiles;

import java.util.Scanner;

public class CompareFilesFabric {

    public static CompareFiles runCompareFiles() {
        Scanner scanner = new Scanner(System.in);
        final String DEFAULT_FILE1 = "file1.txt";
        final String DEFAULT_FILE2 = "file2.txt";

        System.out.println("Введите путь к первому файлу (Enter для использования " + DEFAULT_FILE1 + "):");
        String path1 = scanner.nextLine();
        if (path1.trim().isEmpty()) {
            path1 = DEFAULT_FILE1;
            System.out.println("Используется путь по умолчанию: " + path1);
        }

        System.out.println("Введите путь ко второму файлу (Enter для использования " + DEFAULT_FILE2 + "):");
        String path2 = scanner.nextLine();
        if (path2.trim().isEmpty()) {
            path2 = DEFAULT_FILE2;
            System.out.println("Используется путь по умолчанию: " + path2);
        }

        CompareFiles compareFiles = new CompareFiles();
        compareFiles.setPath1(path1);
        compareFiles.setPath2(path2);
        compareFiles.compareFiles();
        return compareFiles;
    }
}
