package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;

public final class Task6 {
    private final static int BASIS = 10;

    private Task6() {
    }

    private static int toNumberFromArray(int[] digits) {
        StringBuilder digitsString = new StringBuilder();

        for (int digit : digits) {
            digitsString.append(digit);
        }

        return  Integer.parseInt(digitsString.toString(), BASIS);
    }

    private static void reverse(int[] array) {
        for (int i = 0; i * 2 < array.length; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    @SuppressWarnings("MagicNumber")
    public static int countK(int inputNumber) {
        if (inputNumber <= 1e3 || inputNumber >= 1e4) {
            return -1;
        } else if (inputNumber == 6174) {
            return 0;
        }

        var number = inputNumber;
        ArrayList<Integer> numberDigits = new ArrayList<>();

        while (number > 0) {
            numberDigits.add(number % BASIS);
            number /= BASIS;
        }

        int[] numberWithoutDuplicates = numberDigits.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(numberWithoutDuplicates);
        if (numberWithoutDuplicates[0] == numberWithoutDuplicates[numberWithoutDuplicates.length - 1]) {
            return -1;
        }

        var lowerNum = toNumberFromArray(numberWithoutDuplicates);

        reverse(numberWithoutDuplicates);
        var biggerNum = toNumberFromArray(numberWithoutDuplicates);

        var returned = countK(biggerNum - lowerNum);

        if (returned == -1) {
            return -1;
        } else {
            return returned + 1;
        }
    }
}
