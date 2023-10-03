package edu.hw1;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Homework1 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Homework1() {
    }

    public static void HelloWorld() {
        LOGGER.info("Привет, мир!");
    }

    public static int minutesToSeconds(String current_time) {
        int minutes = Integer.parseInt(current_time.substring(0, 2));
        int seconds = Integer.parseInt(current_time.substring(3, 5));

        if (seconds >= 60) {
            return -1;
        }

        return minutes * 60 + seconds;
    }


    public static void main(String[] args) {
        HelloWorld();
        minutesToSeconds("12:35");
    }
}
