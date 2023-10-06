package edu.hw1;

public final class Task4 {
    private Task4() {
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

}
