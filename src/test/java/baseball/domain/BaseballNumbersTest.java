package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}