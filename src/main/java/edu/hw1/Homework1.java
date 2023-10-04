package edu.hw1;

import java.util.Arrays;
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
//    public static void main(String[] args) {
//        helloWorld();
//    }
}
