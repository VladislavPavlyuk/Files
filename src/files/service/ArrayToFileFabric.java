package files.service;

import files.models.ArrayToFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayToFileFabric {
    public void ArrayToFile() throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Ввод пути к файлу
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        // Ввод массива целых чисел
        System.out.print("Введите элементы массива через пробел: ");
        String[] input = scanner.nextLine().split(" ");
        int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        ArrayToFile arrayToFile = new ArrayToFile(array,filePath);
        arrayToFile.oddsEvensDivide();
        arrayToFile.saveFile(arrayToFile.arrayReturn(),filePath);

    }
}
