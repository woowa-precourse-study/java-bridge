package bridge.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {
    private GameResult result = new GameResult(List.of(), true);

    @Test
    void 결과지에_새로운_움직임을_추가하는_테스트() {
        //given
        String move = "D";
        boolean success = true;
        //when
        GameResult add = result.add(move, success);
        //then
        Assertions.assertThat(add.getResult())
                .hasSize(1)
                .contains(move);
    }
}
