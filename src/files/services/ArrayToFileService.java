package files.services;

import files.interfaces.IFileWriter;
import files.interfaces.IInputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayToFileService {
    private final IFileWriter fileWriter;
    private final IInputReader inputReader;
    private final ArrayDivider divider;
    private final ArrayReverser reverser;

    public ArrayToFileService(IFileWriter fileWriter, IInputReader inputReader) {
        this.fileWriter = fileWriter;
        this.inputReader = inputReader;
        this.divider = new ArrayDivider();
        this.reverser = new ArrayReverser();
    }

    public String getInputFilePath() {
        return inputReader.readLineWithDefault(
            "Введите путь к файлу (Enter для использования tempArray.txt): ",
            "tempArray.txt"
        );
    }

    public int[] getInputArray() {
        String inputLine = inputReader.readLine(
            "Введите элементы массива через пробел (Enter для генерации массива): "
        );
        
        if (inputLine.trim().isEmpty()) {
            return generateArray();
        } else {
            String[] input = inputLine.split(" ");
            return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        }
    }

    private int[] generateArray() {
        Random random = new Random();
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Сгенерирован массив: " + Arrays.toString(array));
        return array;
    }

    public void saveArrayToFile(int[] array, String filePath) throws IOException {
        ArrayDivider.DivisionResult division = divider.divide(array);
        int[] reversedArray = reverser.reverse(array);

        List<String> lines = Arrays.asList(
            formatArray(array),
            formatList(division.getEvenNumbers()),
            formatList(division.getOddNumbers()),
            formatArray(reversedArray)
        );

        fileWriter.writeLines(filePath, lines);
        System.out.println("Данные успешно записаны в файл.");
    }

    private String formatArray(int[] array) {
        return Arrays.toString(array).replaceAll("[\\[\\],]", "");
    }

    private String formatList(List<Integer> list) {
        return list.toString().replaceAll("[\\[\\],]", "");
    }
}


