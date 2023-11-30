package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.GameCommand;
import baseball.service.BaseballService;
import baseball.view.BaseballView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballController {

    private final BaseballView baseballView;
    private final BaseballService baseballService;

    public BaseballController(BaseballView baseballView, BaseballService baseballService) {
        this.baseballView = baseballView;
        this.baseballService = baseballService;
    }

    public void gameStart() {
        baseballView.printGameStart();
        playRounds();
        baseballView.printGameOver();
        readRestartOrQuitGame();
    }

    private BaseballNumbers validateIsNumber(String input) throws IllegalArgumentException {
        try {
            List<Integer> numbers = Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new BaseballNumbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private String playRound() {
        while (true) {
            try {
                BaseballNumbers playerNumbers = validateIsNumber(baseballView.readPlayerNumbers());
                baseballService.playRound(playerNumbers);
                return baseballService.getRoundResult();
            } catch (IllegalArgumentException e) {
                baseballView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void playRounds() {
        while (true) {
            String roundResult = playRound();
            baseballView.printRoundResult(roundResult);
            if (baseballService.isGameOver()) {
                break;
            }
        }
    }

    private void readRestartOrQuitGame() {
        while (true) {
            try {
                GameCommand command = GameCommand.
                        findCommandByInput(Integer.parseInt(baseballView.readRestartOrExitGame()));
                if (command == GameCommand.RESTART) {
                    baseballService.resetGame();
                    gameStart();
                }
                break;
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }
}

