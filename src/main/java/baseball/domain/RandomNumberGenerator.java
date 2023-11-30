package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.global.BaseballConstant.BASEBALL_NUMBER_SIZE;
import static baseball.global.BaseballConstant.MAX_NUMBER_RANGE;
import static baseball.global.BaseballConstant.MIN_NUMBER_RANGE;

public class RandomNumberGenerator {

    public BaseballNumbers generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BASEBALL_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new BaseballNumbers(numbers);
    }
}
