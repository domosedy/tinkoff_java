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
            int time_returned = Homework1.minutesToSeconds(value);
            assertThat(time_returned).isEqualTo(0);
        }

        {
            String value = "13:56";
            int time_returned = Homework1.minutesToSeconds(value);
            assertThat(time_returned).isEqualTo(836);
        }

        {
            String value = "10:60";
            int time_returned = Homework1.minutesToSeconds(value);
            assertThat(time_returned).isEqualTo(-1);
        }
    }

    @Test
    @DisplayName("Количество цифр")
    void countDigitsInNumber() {
        assertThat(Homework1.countDigits(4556)).isEqualTo(4);
        assertThat(Homework1.countDigits(-4556)).isEqualTo(4);

        assertThat(Homework1.countDigits(544)).isEqualTo(3);

        assertThat(Homework1.countDigits(0)).isEqualTo(1);
        assertThat(Homework1.countDigits(-1)).isEqualTo(1);
    }

    @Test
    @DisplayName("Вложенные массивы")
    void isNestable() {
        int[] nesty = {1, 2, 3, 4};
        int[] container = {0, 6};

        assertThat(Homework1.isNestable(nesty, container)).isEqualTo(true);
    }
}
