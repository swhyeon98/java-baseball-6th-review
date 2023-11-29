package baseball.domain;

import java.util.List;

public class Umpire {

    private final int strikeCount;
    private final int ballCount;

    public Umpire(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public Umpire match(List<Integer> playerNumbers, List<Integer> computerNumbers) {
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
        return new Umpire(ballCount, strikeCount);
    }
}
