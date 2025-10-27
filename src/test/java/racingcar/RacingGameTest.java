package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 단독_우승자를_찾는다() {
        // given
        Car pobi = new Car("pobi");
        pobi.move(4);
        pobi.move(4);

        Car woni = new Car("woni");
        woni.move(4);
        woni.move(3);

        RacingGame testGame = RacingGame.fromCarsForTest(List.of(pobi, woni));

        // when
        List<String> winners = testGame.findWinners();

        // then
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 공동_우승자를_찾는다() {
        // given
        Car pobi = new Car("pobi");
        pobi.move(4);
        pobi.move(4);

        Car woni = new Car("woni");
        woni.move(4);
        woni.move(3);

        Car jun = new Car("jun");
        jun.move(4);
        jun.move(4);

        RacingGame testGame = RacingGame.fromCarsForTest(List.of(pobi, woni, jun));

        // when
        List<String> winners = testGame.findWinners();

        // then
        assertThat(winners).containsExactly("pobi", "jun");
    }
}