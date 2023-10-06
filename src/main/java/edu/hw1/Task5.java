package edu.hw1;

public final class Task5 {
    private static final int BASIS = 10;

    private Task5() {
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
                int newDigit = Integer.parseInt(String.valueOf(oldNum.charAt(i)));
                if (i + 1 < oldNum.length()) {
                    newDigit += Integer.parseInt(String.valueOf(oldNum.charAt(i + 1)));
                }

                newNum.append(newDigit);
            }

            number = Integer.parseInt(newNum.toString());
        }

        return false;
    }
}
