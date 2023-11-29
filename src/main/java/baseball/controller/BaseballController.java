package baseball.controller;

import baseball.view.BaseballView;

import java.util.regex.Pattern;

public class BaseballController {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    private final BaseballView baseballView;

    public BaseballController(BaseballView baseballView) {
        this.baseballView = baseballView;
    }

    public void start() {

    }

    private void validateIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
