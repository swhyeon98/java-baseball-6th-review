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
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 존재합니다.");
        }
    }
}
