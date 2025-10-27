package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {

    @Test
    void 횟수가_숫자가_아니면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.parseTryCount("a"))
                .withMessageContaining("숫자여야 합니다");
    }

    @Test
    void 횟수가_0이면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.parseTryCount("0"))
                .withMessageContaining("1 이상이어야 합니다");
    }

    @Test
    void 횟수가_음수이면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.parseTryCount("-1"))
                .withMessageContaining("1 이상이어야 합니다");
    }

    @Test
    void 정상적인_횟수는_숫자로_변환된다() {
        int count = InputValidator.parseTryCount("5");
        assertThat(count).isEqualTo(5);
    }
}
