package files.services;

import java.util.ArrayList;
import java.util.List;

public class ArrayDivider {
    public static class DivisionResult {
        private final List<Integer> evenNumbers;
        private final List<Integer> oddNumbers;

        public DivisionResult(List<Integer> evenNumbers, List<Integer> oddNumbers) {
            this.evenNumbers = evenNumbers;
            this.oddNumbers = oddNumbers;
        }

        public List<Integer> getEvenNumbers() {
            return evenNumbers;
        }

        public List<Integer> getOddNumbers() {
            return oddNumbers;
        }
    }

    public DivisionResult divide(int[] array) {
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for (int num : array) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        return new DivisionResult(evenNumbers, oddNumbers);
    }
}


