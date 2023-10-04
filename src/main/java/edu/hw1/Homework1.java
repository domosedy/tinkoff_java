package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class Homework1 {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int SECONDS_IN_MINUTE = 60;
    private final static int BASIS = 10;


    private Homework1() {
    }

    public static void helloWorld() {
        LOGGER.info("Привет, мир!");
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(@NotNull String currentTime) {
        int minutes = Integer.parseInt(currentTime.substring(0, 2));
        int seconds = Integer.parseInt(currentTime.substring(3, 5));

        if (seconds >= SECONDS_IN_MINUTE) {
            return -1;
        }

        return minutes * SECONDS_IN_MINUTE + seconds;
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

    public static boolean isNestable(int[] nestyArray, int[] container) {
        if (container.length == 0) {
            return false;
        } else if (nestyArray.length == 0) {
            return true;
        }

        int maxInFirst = Arrays.stream(nestyArray).max().getAsInt();
        int minInFirst = Arrays.stream(nestyArray).min().getAsInt();

        int maxInSecond = Arrays.stream(container).max().getAsInt();
        int minInSecond = Arrays.stream(container).min().getAsInt();

        return (minInSecond < minInFirst) && (maxInFirst < maxInSecond);
    }

    public static String fixString(String inputString) {
        StringBuilder currentString = new StringBuilder();

        for (int i = 0; i < inputString.length(); i += 2) {
            if (i + 1 < inputString.length()) {
                currentString.append(inputString.charAt(i + 1));
                currentString.append(inputString.charAt(i));
            } else {
                currentString.append(inputString.charAt(i));
            }
        }

        return currentString.toString();
    }

    private static int getReversedNum(int number) {
        if (number == 0) {
            return 0;
        }

        int numCopy = number;

        int reversedNum = 0;

        while (numCopy > 0) {
            reversedNum = reversedNum * BASIS + numCopy % BASIS;
            numCopy /= BASIS;
        }

        return reversedNum;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int inputValue) {
        if (inputValue < 10) {
            return false;
        }

        int number = inputValue;

        while (number >= 10) {
            if (number == getReversedNum(number)) {
                return true;
            }

            StringBuilder newNum = new StringBuilder();
            String oldNum = Integer.toString(number);

            for (int i = 0; i < oldNum.length(); i += 2) {
                if (i + 1 < oldNum.length()) {
                    int newDigit = Integer.parseInt(String.valueOf(oldNum.charAt(i)))
                                    + Integer.parseInt(String.valueOf(oldNum.charAt(i + 1)));

                    newNum.append(newDigit);
                } else {
                    int newDigit = Integer.parseInt(String.valueOf(oldNum.charAt(i)));
                    newNum.append(newDigit);
                }
            }

            number = Integer.parseInt(newNum.toString());
            LOGGER.debug("New number is " + String.valueOf(number));
        }

        return false;
    }

    private static int toNumberFromArray(int[] digits) {
        StringBuilder digitsString = new StringBuilder();

        for (int digit : digits) {
            digitsString.append(digit);
        }

        return  Integer.parseInt(digitsString.toString());
    }

    private static void reverse(int[] array) {
        for (int i = 0; i * 2 < array.length; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static int countK(int inputNumber) {
        if (inputNumber <= 1e3 || inputNumber >= 1e4) {
            return -1;
        } else if (inputNumber == 6174) {
            return 0;
        }

        var number = inputNumber;
        ArrayList<Integer> numberDigits = new ArrayList<Integer>();

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

        return switch (returned) {
            case -1 -> -1;
            default -> returned + 1;
        };
    }
    public static void main(String[] args) {
        LOGGER.info(countK(6621));
    }
}
