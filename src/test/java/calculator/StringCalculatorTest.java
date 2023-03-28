package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    public void setCalculator() {
        calculator = new StringCalculator();
    }

    @Test
    public void sum_null_또는_빈문자() {
        int result = calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void sum_숫자하나() throws Exception {
        int result = calculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void sum_쉼표구분자() throws Exception {
        int result = calculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void sum_쉼표_또는_콜론_구분자() throws Exception {
        int result = calculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void sum_custom_구분자() throws Exception {
        int result = calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void sum_negative() throws Exception {
        assertThatThrownBy(() -> calculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
       }
}
