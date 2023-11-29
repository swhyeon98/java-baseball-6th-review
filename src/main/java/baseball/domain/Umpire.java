package baseball.domain;

import java.util.List;

public class Umpire {

    private int strikeCount;
    private int ballCount;

    public Umpire() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public Umpire match(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        strikeCount = 0;
        ballCount = 0;

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
        return this;
    }
}
