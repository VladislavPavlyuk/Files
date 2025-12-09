package files.service;

import files.factories.ServiceFactory;
import files.services.ArrayToFileService;

import java.io.IOException;

public class ArrayToFileFabric {
    private final ArrayToFileService arrayToFileService;

    public ArrayToFileFabric() {
        this.arrayToFileService = ServiceFactory.createArrayToFileService();
    }

    public void ArrayToFile() throws IOException {
        String filePath = arrayToFileService.getInputFilePath();
        int[] array = arrayToFileService.getInputArray();
        arrayToFileService.saveArrayToFile(array, filePath);
    }
}
