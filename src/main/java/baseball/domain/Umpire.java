package baseball.domain;

import java.util.List;

import static baseball.global.BaseballConstant.INITIAL_VALUE;
import static baseball.global.BaseballConstant.MAX_NUMBER_SIZE;
import static baseball.global.BaseballConstant.WINNING_STRIKE_COUNT;

public class Umpire {

    private final GameStatus gameStatus;

    public Umpire() {
        this.gameStatus = new GameStatus();
    }

    public void match(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = INITIAL_VALUE;
        int ballCount = INITIAL_VALUE;

        for (int i = INITIAL_VALUE; i < MAX_NUMBER_SIZE; i++) {
            int playerNumber = playerNumbers.get(i);

            if (computerNumbers.get(i).equals(playerNumber)) {
                strikeCount++;
                continue;
            }
            if (computerNumbers.contains(playerNumber)) {
                ballCount++;
            }
        }
        gameStatus.update(strikeCount, ballCount);
    }

    public String getResult() {
        return gameStatus.toString();
    }

    public boolean isGameOver() {
        return gameStatus.getStrikeCount() == WINNING_STRIKE_COUNT;
    }
}
