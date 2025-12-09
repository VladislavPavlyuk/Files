package files.service;

import files.factories.ServiceFactory;
import files.presentation.LongestLineDisplay;
import files.services.LongestLineFinderService;

import java.io.IOException;

public class LongestLineFinderFabric {
    private final LongestLineFinderService finderService;
    private final LongestLineDisplay display;
    private final files.interfaces.IInputReader inputReader;

    public LongestLineFinderFabric() {
        this.finderService = ServiceFactory.createLongestLineFinderService();
        this.display = new LongestLineDisplay();
        this.inputReader = ServiceFactory.createInputReader();
    }

    public String runLongestLineFinder() {
        String filePath = inputReader.readLineWithDefault(
            "Введите путь к файлу (Enter для использования file1.txt): ",
            "file1.txt"
        );

        try {
            LongestLineFinderService.LongestLineResult result = finderService.findLongestLine(filePath);
            display.display(result);
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }
        return filePath;
    }
}
