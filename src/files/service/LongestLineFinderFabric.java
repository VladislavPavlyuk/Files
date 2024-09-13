package files.service;

import files.models.LongestLineFinder;

import java.util.Scanner;

public class LongestLineFinderFabric {

    public static String runLongestLineFinder() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        LongestLineFinder longestLineFinder = new LongestLineFinder(filePath);
        longestLineFinder.findLongestLine(filePath);
        return filePath;
    }
}
