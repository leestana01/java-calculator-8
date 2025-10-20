package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 쉼표_구분자로_두_숫자_입력시_합_반환() {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_구분자로_여러_숫자_입력시_합_반환() {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate("1,2,3")).isEqualTo(6);
        assertThat(calculator.calculate("1:2:3")).isEqualTo(6);
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_사용() {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(calculator.calculate("//|\n1|2|3")).isEqualTo(6);
        assertThat(calculator.calculate("//;\n1")).isEqualTo(1);
    }

    @Test
    void 음수_입력시_예외_발생() {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
