package racingcar;

import java.util.List;

public class OutputView {

    public static void printExecutionResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String hyphens = convertPositionToHyphens(car.getPosition());
            System.out.println(car.getName() + " : " + hyphens);
        }
        System.out.println();
    }

    private static String convertPositionToHyphens(int position) {
        return "-".repeat(position);
    }
}
