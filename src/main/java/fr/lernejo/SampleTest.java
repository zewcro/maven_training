package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SampleTest {
    private final Sample sample = new Sample();

    @Test
    void fact_with_number_zero() {
        int n = 0;
        int result = sample.fact(n);

        Assertions.assertThat(result)
            .as("Factor of " + n)
            .isEqualTo(1);
    }

    @Test
    void fact_with_positive_number() {
        int n = 3;
        int result = sample.fact(n);

        Assertions.assertThat(result)
            .as("Factor of " + n)
            .isEqualTo(6);
    }

    @Test
    void fact_with_negative_number() {
        int n = -1;

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(n));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, -4, 1",
        "-5, 4, -1",
        "-1, -2, -3"
    })
    void add_integers(int a, int b, int expectedResult) {
        int result = sample.op(Sample.Operation.ADD, a, b);

        Assertions.assertThat(result)
            .as("Addition of " + a + " and " + b)
            .isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 2",
        "5, -4, -20",
        "-5, 4, -20",
        "-1, -3, 3"
    })
    void mult_integers(int a, int b, int expectedResult) {
        int result = sample.op(Sample.Operation.MULT, a, b);

        Assertions.assertThat(result)
            .as("Multiplication of " + a + " and " + b)
            .isEqualTo(expectedResult);
    }
}
