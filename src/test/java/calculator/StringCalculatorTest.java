package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void 빈_문자열_입력시_0_반환() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나_입력시_해당_숫자_반환() {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate("1")).isEqualTo(1);
        assertThat(calculator.calculate("5")).isEqualTo(5);
    }
}
