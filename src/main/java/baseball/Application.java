package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.BaseballView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView(new InputView(), new OutputView());
        BaseballService baseballService = new BaseballService();
        BaseballController baseballController = new BaseballController(baseballView, baseballService);
        baseballController.gameStart();
    }
}

