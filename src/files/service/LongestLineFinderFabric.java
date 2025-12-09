package files.service;

import files.models.LongestLineFinder;

import java.util.Scanner;

public class LongestLineFinderFabric {

    public static String runLongestLineFinder() {

        Scanner scanner = new Scanner(System.in);
        final String DEFAULT_FILE = "file1.txt";

        System.out.println("Введите путь к файлу (Enter для использования " + DEFAULT_FILE + "):");
        String filePath = scanner.nextLine();
        if (filePath.trim().isEmpty()) {
            filePath = DEFAULT_FILE;
            System.out.println("Используется путь по умолчанию: " + filePath);
        }

        LongestLineFinder longestLineFinder = new LongestLineFinder(filePath);
        longestLineFinder.findLongestLine(filePath);
        return filePath;
    }
}
