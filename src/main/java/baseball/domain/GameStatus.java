package baseball.domain;

public class GameStatus {

    private int strikeCount;
    private int ballCount;

    public GameStatus() {
        this.strikeCount = 0;
        this.ballCount = 0;
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
        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }
        if (ballCount > 0) {
            return ballCount + "볼";
        }
        return "낫싱";
    }
}
