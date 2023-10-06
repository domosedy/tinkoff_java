package edu.hw1;

import java.util.ArrayList;

public final class Task7 {
    private static final int BASIS = 2;

    private Task7() {
    }

    private static void reverse(int[] array) {
        for (int i = 0; i * 2 < array.length; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    private static int toNumberFromArray(int[] digits) {
        StringBuilder digitsString = new StringBuilder();

        for (int digit : digits) {
            digitsString.append(digit);
        }

        return  Integer.parseInt(digitsString.toString(), BASIS);
    }

    private static int[] transformIntToBit(int number) {
        final int CURR_BASIS = 2;
        ArrayList<Integer> bitNumber = new ArrayList<>();

        int currNumber = number;

        if (currNumber == 0) {
            return new int[]{0};
        }

        while (currNumber > 0) {
            bitNumber.add(currNumber % CURR_BASIS);
            currNumber /= CURR_BASIS;
        }

        int[] num = bitNumber.stream().mapToInt(Integer::intValue).toArray();
        reverse(num);
        return num;
    }

    private static int getBitLength(int inputNumber) {
        if (inputNumber == 0) {
            return 1;
        }

        int number = inputNumber;
        int count = 0;

        while (number > 0) {
            count++;
            number >>= 1;
        }
        return count;
    }

    public static int rotateLeft(int inputNumber, int inputShift) {
        int shift = inputShift;
        var bitNumber = transformIntToBit(inputNumber);

        shift %= bitNumber.length;

        if (shift < 0) {
            shift += bitNumber.length;
        }

        int[] tempBits = new int[shift];

        for (int i = 0; i < shift; i++) {
            tempBits[i] = bitNumber[i];
        }

        for (int i = shift; i < bitNumber.length; i++) {
            bitNumber[i - shift] = bitNumber[i];
        }

        for (int i = 0; i < shift; i++) {
            bitNumber[i + bitNumber.length - shift] = tempBits[i];
        }

        return toNumberFromArray(bitNumber);
    }

    public static int rotateRight(int inputNumber, int inputShift) {
        int shift = inputShift;
        int len = getBitLength(inputNumber);

        shift = len - shift;
        shift %= len;

        if (shift < 0) {
            shift += len;
        }

        return rotateLeft(inputNumber, shift);
    }
}
