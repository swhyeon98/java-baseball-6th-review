package baseball.domain;

import java.util.List;

public class Umpire {

    private final GameStatus gameStatus;

    public Umpire() {
        this.gameStatus = new GameStatus();
    }

    public void match(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
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
        return gameStatus.getStrikeCount() == 3;
    }
}
