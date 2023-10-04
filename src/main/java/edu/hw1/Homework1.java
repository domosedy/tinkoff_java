package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class Homework1 {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int SECONDS_IN_MINUTE = 60;

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

        final int BASIS = 10;
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

        return (minInSecond <= minInFirst) && (maxInFirst <= maxInSecond);
    }


//    public static void main(String[] args) {
//        helloWorld();
//    }
}
