package baseball.service;

import baseball.domain.BaseballNumbers;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Umpire;

public class BaseballService {

    private final RandomNumberGenerator numberGenerator;
    private final Umpire umpire;
    private BaseballNumbers computerNumbers;

    public BaseballService() {
        this.numberGenerator = new RandomNumberGenerator();
        this.umpire = new Umpire();
        init();
    }

    private void init() {
        this.computerNumbers = numberGenerator.generate();
    }

    public void playRound(BaseballNumbers playerNumbers) {
        umpire.match(playerNumbers.getNumbers(), computerNumbers.getNumbers());
    }

    public String getRoundResult() {
        return umpire.getResult();
    }

    public boolean isGameOver() {
        return umpire.isGameOver();
    }

    public void resetGame() {
        init();
    }
}
