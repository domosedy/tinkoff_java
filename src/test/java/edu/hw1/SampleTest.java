package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    @DisplayName("Длина видео")
    void filterEvenNumbers() {
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
}
