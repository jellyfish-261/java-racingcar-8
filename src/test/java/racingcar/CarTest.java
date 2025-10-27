package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 랜덤값이_4일때_전진한다() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_9일때도_전진한다() {
        Car car = new Car("pobi");
        car.move(9);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤값이_3일때_멈춘다() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤값이_0일때도_멈춘다() {
        Car car = new Car("pobi");
        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
