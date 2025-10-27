package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    private RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingGame fromNames(List<String> carNames) {
        List<Car> carList = createCarsFromNames(carNames);
        return new RacingGame(carList);
    }

    static RacingGame fromCarsForTest(List<Car> cars) {
        return new RacingGame(new ArrayList<>(cars));
    }

    private static List<Car> createCarsFromNames(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void runOneRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinnerIfMax(car, maxPosition, winners);
        }
        return winners;
    }

    private int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private void addWinnerIfMax(Car car, int maxPosition, List<String> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}