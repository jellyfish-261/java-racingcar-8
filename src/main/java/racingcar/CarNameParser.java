package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNameParser {

    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> parse(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            String trimmedName = name.trim();
            validateName(trimmedName);
            carNames.add(trimmedName);
        }
        return carNames;
    }

    private static void validateName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}