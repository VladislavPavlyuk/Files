package files.presentation;

import files.services.LongestLineFinderService;

public class LongestLineDisplay {
    public void display(LongestLineFinderService.LongestLineResult result) {
        System.out.println("Длина самой длинной строки: " + result.getLength());
        System.out.println("Сама строка: " + result.getLine());
    }
}


