package baseball.domain.computer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 존재합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean outOfNumberRange = numbers.stream()
                .anyMatch(number -> number < 1 || number > 9);
        if (outOfNumberRange) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위를 벗어나는 수가 존재합니다. 숫자의 범위는 1부터 9까지입니다.");
        }
    }
}
