package baseball.domain;

import static baseball.global.BaseballConstant.INITIAL_VALUE;

public class GameStatus {

    private int strikeCount;
    private int ballCount;

    public GameStatus() {
        this.strikeCount = INITIAL_VALUE;
        this.ballCount = INITIAL_VALUE;
    }

    public void update(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public String toString() {
        if (strikeCount > INITIAL_VALUE && ballCount > INITIAL_VALUE) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
        if (strikeCount > INITIAL_VALUE) {
            return strikeCount + "스트라이크";
        }
        if (ballCount > INITIAL_VALUE) {
            return ballCount + "볼";
        }
        return "낫싱";
    }
}

