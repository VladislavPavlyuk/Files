import files.models.ArrayProcessor;
import files.service.ArrayToFileFabric;
import files.service.CompareFilesFabric;
import files.service.CorporationFabric;
import files.service.LongestLineFinderFabric;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> tasks = readTasksFromReadme();
        
        System.out.println("=== Начало выполнения задач ===\n");
        
        // Задание 1
        if (tasks.size() > 0) {
            System.out.println("Выполняется: " + tasks.get(0));

        }
        CompareFilesFabric compareFilesFabric = new CompareFilesFabric();
        compareFilesFabric.runCompareFiles();
        System.out.println("\n Задание 1 завершено\n");

        // Задание 2
        if (tasks.size() > 1) {
            System.out.println("Выполняется: " + getTaskDescription(tasks, 1) + "\n");
        }
        LongestLineFinderFabric longestLineFinderFabric = new LongestLineFinderFabric();
        longestLineFinderFabric.runLongestLineFinder();
        System.out.println("\n Задание 2 завершено\n");

        // Задание 3
        if (tasks.size() > 2) {
            System.out.println("Выполняется: " + getTaskDescription(tasks, 2) + "\n");
        }
        ArrayProcessor arrayProcessor = new ArrayProcessor();
        arrayProcessor.run(arrayProcessor.inputFilename());
        System.out.println("\n Задание 3 завершено\n");

        // Задание 4
        if (tasks.size() > 3) {

            System.out.println("Выполняется: " + getTaskDescription(tasks, 3) + "\n");
        }
        ArrayToFileFabric arrayToFileFabric = new ArrayToFileFabric();
        arrayToFileFabric.ArrayToFile();
        System.out.println("\n Задание 4 завершено\n");

        // Задание 5
        if (tasks.size() > 4) {
            System.out.println("Выполняется: " + getTaskDescription(tasks, 4) + "\n");
        }
        CorporationFabric corporationFabric = new CorporationFabric();
        corporationFabric.createCorporation();
        System.out.println("\n Задание 5 завершено\n");

        System.out.println("=== Все задачи выполнены ===");
    }

    private static List<String> readTasksFromReadme() throws IOException {
        List<String> tasks = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("README.md"));
        
        StringBuilder currentTask = new StringBuilder();
        for (String line : lines) {
            if (line.startsWith("Задание")) {
                if (currentTask.length() > 0) {
                    tasks.add(currentTask.toString().trim());
                }
                currentTask = new StringBuilder(line);
            } else if (line.trim().isEmpty() && currentTask.length() > 0) {
                // Пропускаем пустые строки между задачами
            } else if (currentTask.length() > 0) {
                currentTask.append(" ").append(line.trim());
            }
        }
        if (currentTask.length() > 0) {
            tasks.add(currentTask.toString().trim());
        }
        
        return tasks;
    }

    private static String getTaskDescription(List<String> tasks, int index) {
        if (index >= tasks.size()) {
            return "";
        }
        String task = tasks.get(index);
        // Убираем заголовок "Задание X" и возвращаем описание
        int firstSpace = task.indexOf(' ');
        if (firstSpace > 0) {
            return task.substring(firstSpace + 1).trim();
        }
        return task;
    }
}