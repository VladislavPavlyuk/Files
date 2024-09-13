package files.models;

import java.io.*;
        import java.util.*;

public class ArrayToFile {

    String filePath;
    private int[] array;
    List<Integer> evenNumbers = new ArrayList<>();
    List<Integer> oddNumbers = new ArrayList<>();

    public ArrayToFile(int[] array, String filePath) throws IOException {
        this.filePath = filePath;
        this.array = array;
    }

    public void setEvenNumbers(List<Integer> evenNumbers) {
        this.evenNumbers = evenNumbers;
    }

    public List<Integer> getEvenNumbers() {
        return evenNumbers;
    }

    public void setOddNumbers(List<Integer> oddNumbers) {
        this.oddNumbers = oddNumbers;
    }

    public List<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void oddsEvensDivide() {  // Разделение на четные и нечетные
        for (int num : array) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }
    }

    public int[] arrayReturn() {                    // Переворачивание массива
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    public void saveFile(int[]reversedArray, String filePath) {    // Запись в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
            writer.newLine();
            writer.write(evenNumbers.toString().replaceAll("[\\[\\],]", ""));
            writer.newLine();
            writer.write(oddNumbers.toString().replaceAll("[\\[\\],]", ""));
            writer.newLine();
            writer.write(Arrays.toString(reversedArray).replaceAll("[\\[\\],]", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Данные успешно записаны в файл.");
    }

}

