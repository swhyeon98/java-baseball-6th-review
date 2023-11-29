package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.BaseballView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BaseballController {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    private final BaseballView baseballView;
    private final BaseballService baseballService;

    public BaseballController(BaseballView baseballView, BaseballService baseballService) {
        this.baseballView = baseballView;
        this.baseballService = baseballService;
    }

    public void start() {
        baseballView.printGameStart();

    }

    private List<Integer> validateIsNumber(String input) throws IllegalArgumentException {
        try {
            List<Integer> numbers = Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
}
