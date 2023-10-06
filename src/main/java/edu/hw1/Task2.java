package edu.hw1;

public final class Task2 {
    private final static int BASIS = 10;

    private Task2() {
    }

    public static int countDigits(int inputNumber) {
        int number = inputNumber;

        if (number == 0) {
            return 1;
        } else if (number < 0) {
            number *= -1;
        }

        int inputNumberOfDigits = 0;

        while (number > 0) {
            inputNumberOfDigits++;
            number /= BASIS;
        }

        return inputNumberOfDigits;
    }

}
