package baseball.service;

import baseball.domain.BaseballNumbers;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Umpire;

public class BaseballService {

    private final RandomNumberGenerator numberGenerator;
    private final Umpire umpire;

    public BaseballService() {
        this.numberGenerator = new RandomNumberGenerator();
        this.umpire = new Umpire();
    }

    public void playRound(BaseballNumbers playerNumbers) {
        BaseballNumbers computerNumbers = numberGenerator.generate();
        umpire.match(playerNumbers.getNumbers(), computerNumbers.getNumbers());
    }

    public String getRoundResult() {
        return umpire.getResult();
    }

    public boolean isGameOver() {
        return umpire.isGameOver();
    }
}
