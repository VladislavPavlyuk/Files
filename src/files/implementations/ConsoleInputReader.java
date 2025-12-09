package files.implementations;

import files.interfaces.IInputReader;

import java.util.Scanner;

public class ConsoleInputReader implements IInputReader {
    private final Scanner scanner;

    public ConsoleInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public String readLineWithDefault(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Используется значение по умолчанию: " + defaultValue);
            return defaultValue;
        }
        return input;
    }

    @Override
    public int readInt(String prompt) {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.print(prompt);
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
}


