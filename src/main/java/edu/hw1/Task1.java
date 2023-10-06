package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task1 {
    private final static int SECONDS_IN_MINUTE = 60;

    private Task1() {
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
}
