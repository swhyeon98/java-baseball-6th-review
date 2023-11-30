package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UmpireTest {

    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;
    private Umpire umpire;


    @BeforeEach
    void setUp() {
        umpire = new Umpire();
    }

    @Test
    void 모든_숫자가_일치할_경우_3스트라이크() throws Exception {
        // given
        playerNumbers = List.of(1, 2, 3);
        computerNumbers = List.of(1, 2, 3);

        // when
        umpire.match(playerNumbers, computerNumbers);
        String result = umpire.getResult();

        // then
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 하나의_숫자가_일치하고_다른_숫자는_다른_자리에_있을_경우_1볼_1스트라이크() throws Exception {
        // given
        playerNumbers = List.of(1, 2, 3);
        computerNumbers = List.of(3, 2, 4);

        // when
        umpire.match(playerNumbers, computerNumbers);
        String result = umpire.getResult();

        // then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 숫자와_위치가_모두_다를_경우_볼_스트라이크_낫싱() throws Exception {
        // given
        playerNumbers = List.of(1, 2, 3);
        computerNumbers = List.of(4, 5, 6);

        // when
        umpire.match(playerNumbers, computerNumbers);
        String result = umpire.getResult();

        // then
        assertThat(result).isEqualTo("낫싱");
    }
}