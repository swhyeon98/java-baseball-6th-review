package baseball.domain;

public enum GameCommand {
    RESTART(1),
    EXIT(2);

    private final int value;

    GameCommand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
