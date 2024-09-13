package files.models;

import java.io.*;
import java.util.*;

public class ArrayProcessor {


    public ArrayProcessor() {}

    public String inputFilename() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу:");
        String fileName = scanner.nextLine();
        return fileName;
    }

    public void run(String fileName) {
        List<int[]> arrays = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int[] array = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
                arrays.add(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int globalSum = 0;

        for (int i = 0; i < arrays.size(); i++) {
            int[] array = arrays.get(i);
            System.out.println("Array " + (i + 1) + ": " + Arrays.toString(array));

            int max = Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
            int min = Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
            int sum = Arrays.stream(array).sum();

            print(max, min, sum);

            if (max > globalMax) globalMax = max;
            if (min < globalMin) globalMin = min;
            globalSum += sum;

            printGlobals(globalMax, globalMin, globalSum);
        }
    }
    public void print(int max, int min, int sum){
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Sum: " + sum);
    }

    public void printGlobals(int globalMax, int globalMin,int globalSum){
        System.out.println("Global Max: " + globalMax);
        System.out.println("Global Min: " + globalMin);
        System.out.println("Global Sum: " + globalSum);
    }
}

