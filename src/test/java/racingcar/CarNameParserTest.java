package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameParserTest {

    @Test
    void 이름이_정상적으로_분리된다() {
        List<String> names = CarNameParser.parse("pobi,woni,jun");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 이름이_5자를_초과하면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameParser.parse("pobi,javaji"))
                .withMessageContaining("5자 이하");
    }

    @Test
    void 이름이_공백이면_예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameParser.parse("pobi,,jun"))
                .withMessageContaining("1자 이상");
    }
}
