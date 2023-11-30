package baseball.view;

public class BaseballView {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printGameStart() {
        outputView.printGameStart();
    }

    public String readPlayerNumbers() {
        return inputView.readPlayerNumbers();
    }

    public void printRoundResult(String result) {
        outputView.printRoundResult(result);
    }

    public void printGameOver() {
        outputView.printGameOver();
    }

    public String readRestartOrExitGame() {
        return inputView.readRestartOrExitGame();
    }

    public void printErrorMessage(String message) {
        outputView.printErrorMessage(message);
    }
}

