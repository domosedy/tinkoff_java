package edu.hw1;

import java.util.Arrays;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] nestableArray, int[] container) {
        if (container.length == 0) {
            return false;
        } else if (nestableArray.length == 0) {
            return true;
        }

        int maxInFirst = Arrays.stream(nestableArray).max().getAsInt();
        int minInFirst = Arrays.stream(nestableArray).min().getAsInt();

        int maxInSecond = Arrays.stream(container).max().getAsInt();
        int minInSecond = Arrays.stream(container).min().getAsInt();

        return (minInSecond < minInFirst) && (maxInFirst < maxInSecond);
    }
}
