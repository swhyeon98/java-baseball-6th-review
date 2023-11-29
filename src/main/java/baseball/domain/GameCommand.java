package baseball.domain;

import java.util.Arrays;

public enum GameCommand {
    RESTART(1),
    QUIT(2);

    private final int value;

    GameCommand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameCommand findCommandByInput(int input) {
        return Arrays.stream(values())
                .filter(gameCommand -> gameCommand.value == input)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 입력입니다. " +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
    }
}
