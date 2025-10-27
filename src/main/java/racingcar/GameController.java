package racingcar;

import java.util.List;

public class GameController {

    public void run() {

        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        RacingGame game = RacingGame.fromNames(carNames);

        runRacingRounds(game, tryCount);
        showWinners(game);
    }

    private List<String> getCarNames() {
        String namesInput = InputView.getCarNamesInput();
        return CarNameParser.parse(namesInput);
    }

    private int getTryCount() {
        String tryCountInput = InputView.getTryCountInput();
        return InputValidator.parseTryCount(tryCountInput);
    }

    private void runRacingRounds(RacingGame game, int tryCount) {
        OutputView.printExecutionResultHeader();
        for (int i = 0; i < tryCount; i++) {
            game.runOneRound();
            OutputView.printRoundResult(game.getCars());
        }
    }

    private void showWinners(RacingGame game) {
        List<String> winners = game.findWinners();
        OutputView.printWinners(winners);
    }
}
