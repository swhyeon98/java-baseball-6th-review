package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    
    @Test
    void 생성_성공() throws Exception {
        // given
        List<Integer> numbers = List.of(1, 2, 3);

        // when
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        
        // then
        assertThat(baseballNumbers.getNumbers()).isEqualTo(numbers);
    }

    @Test
    void 중복된_숫자가_있을_경우_예외_발생() throws Exception {
        // given
        List<Integer> duplicateNumbers = List.of(1, 1, 1, 2, 3);

        // when & then
        assertThatThrownBy(() -> new BaseballNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복이 존재합니다.");
    }

    @Test
    void 숫자_범위가_1부터_9가_아닌_경우_예외_발생() throws Exception {
        // given
        List<Integer> outOfRangeNumbers = List.of(1,2,10);

        // when & then
        assertThatThrownBy(() -> new BaseballNumbers(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위를 벗어나는 수가 존재합니다. 숫자의 범위는 1부터 9까지입니다.");
    }

    @Test
    void 숫자가_3자리가_아닐_경우_예외_발생() throws Exception {
        // given
        List<Integer> notThreeDigits  = List.of(1,2);

        // when & then
        assertThatThrownBy(() -> new BaseballNumbers(notThreeDigits))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자는 3자리만 허용됩니다.");
    }
}