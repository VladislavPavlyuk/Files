package files.services;

import files.interfaces.IArrayStatistics;
import files.interfaces.IFileReader;
import files.interfaces.IInputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProcessorService {
    private final IFileReader fileReader;
    private final IArrayStatistics statistics;
    private final IInputReader inputReader;

    public ArrayProcessorService(IFileReader fileReader, IArrayStatistics statistics, IInputReader inputReader) {
        this.fileReader = fileReader;
        this.statistics = statistics;
        this.inputReader = inputReader;
    }

    public String getInputFilename() {
        return inputReader.readLineWithDefault(
            "Введите путь к файлу (Enter для использования arrays.txt): ",
            "arrays.txt"
        );
    }

    public List<int[]> loadArraysFromFile(String fileName) throws IOException {
        List<int[]> arrays = new ArrayList<>();
        List<String> lines = fileReader.readLines(fileName);
        
        for (String line : lines) {
            String[] parts = line.split("[\\s,]+");
            int[] array = Arrays.stream(parts)
                    .filter(s -> !s.trim().isEmpty())
                    .mapToInt(s -> Integer.parseInt(s.trim()))
                    .toArray();
            if (array.length > 0) {
                arrays.add(array);
            }
        }
        return arrays;
    }

    public void processArrays(List<int[]> arrays) {
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int globalSum = 0;

        for (int i = 0; i < arrays.size(); i++) {
            int[] array = arrays.get(i);
            System.out.println("Array " + (i + 1) + ": " + Arrays.toString(array));

            int max = statistics.getMax(array);
            int min = statistics.getMin(array);
            int sum = statistics.getSum(array);

            printStatistics(max, min, sum);

            if (max > globalMax) globalMax = max;
            if (min < globalMin) globalMin = min;
            globalSum += sum;

            printGlobalStatistics(globalMax, globalMin, globalSum);
        }
    }

    private void printStatistics(int max, int min, int sum) {
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Sum: " + sum);
    }

    private void printGlobalStatistics(int globalMax, int globalMin, int globalSum) {
        System.out.println("Global Max: " + globalMax);
        System.out.println("Global Min: " + globalMin);
        System.out.println("Global Sum: " + globalSum);
    }
}


