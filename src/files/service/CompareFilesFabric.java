package files.service;

import files.factories.ServiceFactory;
import files.services.FileComparisonService;

import java.io.IOException;

public class CompareFilesFabric {
    private final FileComparisonService comparisonService;
    private final files.interfaces.IInputReader inputReader;

    public CompareFilesFabric() {
        this.comparisonService = ServiceFactory.createFileComparisonService();
        this.inputReader = ServiceFactory.createInputReader();
    }

    public void runCompareFiles() {
        String path1 = inputReader.readLineWithDefault(
            "Введите путь к первому файлу (Enter для использования file1.txt): ",
            "file1.txt"
        );

        String path2 = inputReader.readLineWithDefault(
            "Введите путь ко второму файлу (Enter для использования file2.txt): ",
            "file2.txt"
        );

        try {
            comparisonService.compareFiles(path1, path2);
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файлов: " + e.getMessage());
        }
    }
}
