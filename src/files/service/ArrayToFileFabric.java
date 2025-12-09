package files.service;

import files.models.ArrayToFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayToFileFabric {
    public void ArrayToFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        final String DEFAULT_FILE = "tempArray.txt";

        // Ввод пути к файлу
        System.out.print("Введите путь к файлу (Enter для использования " + DEFAULT_FILE + "): ");
        String filePath = scanner.nextLine();
        if (filePath.trim().isEmpty()) {
            filePath = DEFAULT_FILE;
            System.out.println("Используется путь по умолчанию: " + filePath);
        }

        // Ввод массива целых чисел
        System.out.print("Введите элементы массива через пробел (Enter для генерации массива): ");
        String inputLine = scanner.nextLine();
        int[] array;
        if (inputLine.trim().isEmpty()) {
            // Генерация массива целых чисел
            Random random = new Random();
            int size = 10; // Размер массива по умолчанию
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(100); // Генерируем числа от 0 до 99
            }
            System.out.println("Сгенерирован массив: " + Arrays.toString(array));
        } else {
            String[] input = inputLine.split(" ");
            array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        }

        ArrayToFile arrayToFile = new ArrayToFile(array,filePath);
        arrayToFile.oddsEvensDivide();
        arrayToFile.saveFile(arrayToFile.arrayReturn(),filePath);

    }
}
