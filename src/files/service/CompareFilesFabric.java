package files.service;

import files.models.CompareFiles;

import java.util.Scanner;

public class CompareFilesFabric {

    public static CompareFiles runCompareFiles() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к первому файлу:");
        String path1 = scanner.nextLine();

        System.out.println("Введите путь ко второму файлу:");
        String path2 = scanner.nextLine();

        CompareFiles compareFiles = new CompareFiles();
        compareFiles.setPath1(path1);
        compareFiles.setPath2(path2);
        compareFiles.compareFiles();
        return compareFiles;
    }
}
