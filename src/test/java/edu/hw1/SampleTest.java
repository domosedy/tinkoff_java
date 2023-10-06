package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    @DisplayName("Длина видео")
    void getVideoLen() {
        // given
        {
            String value = "00:00";
            int time_returned = Task1.minutesToSeconds(value);
            assertThat(time_returned).isEqualTo(0);
        }

        {
            String value = "13:56";
            int time_returned = Task1.minutesToSeconds(value);
            assertThat(time_returned).isEqualTo(836);
        }

        {
            String value = "10:60";
            int time_returned = Task1.minutesToSeconds(value);
            assertThat(time_returned).isEqualTo(-1);
        }
    }

    @Test
    @DisplayName("Количество цифр")
    void countDigitsInNumber() {
        assertThat(Task2.countDigits(4556)).isEqualTo(4);
        assertThat(Task2.countDigits(-4556)).isEqualTo(4);

        assertThat(Task2.countDigits(544)).isEqualTo(3);

        assertThat(Task2.countDigits(0)).isEqualTo(1);
        assertThat(Task2.countDigits(-1)).isEqualTo(1);
    }

    @Test
    @DisplayName("Вложенные массивы")
    void isNestable() {
        {
            int[] nesty = {1, 2, 3, 4};
            int[] container = {0, 6};

            assertThat(Task3.isNestable(nesty, container)).isEqualTo(true);
        }

        {
            int[] nesty = {3, 1};
            int[] container = {4, 0};

            assertThat(Task3.isNestable(nesty, container)).isEqualTo(true);
        }

        {
            int[] nesty = {9, 9, 8};
            int[] container = {8, 9};

            assertThat(Task3.isNestable(nesty, container)).isEqualTo(false);
        }

        {
            int[] nesty = {1, 2, 3, 4};
            int[] container = {2, 3};

            assertThat(Task3.isNestable(nesty, container)).isEqualTo(false);
        }

        {
            int[] nesty = {};
            int[] container = {0, 6};

            assertThat(Task3.isNestable(nesty, container)).isEqualTo(true);
        }

        {
            int[] nesty = {1, 2, 3, 4};
            int[] container = {};

            assertThat(Task3.isNestable(nesty, container)).isEqualTo(false);
        }
    }

    @Test
    @DisplayName("Сломанная строка")
    void fixedString() {
        assertThat(Task4.fixString("123456")).isEqualTo("214365");
        assertThat(Task4.fixString("hTsii  s aimex dpus rtni.g"))
            .isEqualTo("This is a mixed up string.");
        assertThat(Task4.fixString("badce")).isEqualTo("abcde");
        assertThat(Task4.fixString("")).isEqualTo("");
        assertThat(Task4.fixString("1")).isEqualTo("1");
    }

    @Test
    @DisplayName("Особый палиндром")
    void isStrangePalindrome() {
        assertThat(Task5.isPalindromeDescendant(11211230)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(13001120)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(23336014)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(12)).isEqualTo(false);
        assertThat(Task5.isPalindromeDescendant(1299)).isEqualTo(false);
        assertThat(Task5.isPalindromeDescendant(11)).isEqualTo(true);
        assertThat(Task5.isPalindromeDescendant(9)).isEqualTo(false);
        assertThat(Task5.isPalindromeDescendant(-1)).isEqualTo(false);
    }

    @Test
    @DisplayName("Постоянная Капрекара")
    void countK() {
        assertThat(Task6.countK(6621)).isEqualTo(5);
        assertThat(Task6.countK(6554)).isEqualTo(4);
        assertThat(Task6.countK(1234)).isEqualTo(3);
        assertThat(Task6.countK(-1)).isEqualTo(-1);
        assertThat(Task6.countK(1000)).isEqualTo(-1);
        assertThat(Task6.countK(1111)).isEqualTo(-1);
        assertThat(Task6.countK(12345)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Циклический битовый сдвиг")
    void bitShift() {
        assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task7.rotateRight(16, 1)).isEqualTo(8);
        assertThat(Task7.rotateRight(16, -1)).isEqualTo(1);
        assertThat(Task7.rotateRight(16, -6)).isEqualTo(1);
        assertThat(Task7.rotateRight(16, -5)).isEqualTo(16);
        assertThat(Task7.rotateLeft(17, 2)).isEqualTo(6);
        assertThat(Task7.rotateLeft(17, 7)).isEqualTo(6);
        assertThat(Task7.rotateLeft(17, -8)).isEqualTo(6);
        assertThat(Task7.rotateLeft(0, 100)).isEqualTo(0);
        assertThat(Task7.rotateRight(0, 100)).isEqualTo(0);

    }

    @Test
    @DisplayName("Кони на доске")
    void knightBoardCapture() {
        {
            int[][] board = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
            };

            assertThat(Task8.knightBoardCapture(board)).isEqualTo(true);
        }

        {
            int[][] board = {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, }
            };

            assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
        }

        {
            int[][] board = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
            };

            assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
        }

        {
            int[][] board = {
                {0, 1}
            };

            assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
        }

        {
            int[][] board = {
                {0},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0}
            };

            assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
        }

        {
            int[][] board = {
                {0, 2, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
            };

            assertThat(Task8.knightBoardCapture(board)).isEqualTo(false);
        }
    }
}
