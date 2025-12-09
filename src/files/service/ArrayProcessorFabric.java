package files.service;

import files.factories.ServiceFactory;
import files.services.ArrayProcessorService;

import java.io.IOException;

public class ArrayProcessorFabric {
    private final ArrayProcessorService arrayProcessorService;

    public ArrayProcessorFabric() {
        this.arrayProcessorService = ServiceFactory.createArrayProcessorService();
    }

    public void run() {
        String fileName = arrayProcessorService.getInputFilename();
        try {
            var arrays = arrayProcessorService.loadArraysFromFile(fileName);
            arrayProcessorService.processArrays(arrays);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


