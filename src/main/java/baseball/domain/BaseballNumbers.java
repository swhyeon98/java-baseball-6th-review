package baseball.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.global.BaseballConstant.MAX_NUMBER_RANGE;
import static baseball.global.BaseballConstant.MAX_NUMBER_SIZE;
import static baseball.global.BaseballConstant.MIN_NUMBER_RANGE;

public class BaseballNumbers {

    private final List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        validateSize(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 존재합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean outOfNumberRange = numbers.stream()
                .anyMatch(number -> number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE);
        if (outOfNumberRange) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위를 벗어나는 수가 존재합니다. 숫자의 범위는 1부터 9까지입니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자는 3자리만 허용됩니다.");
        }
    }
}

