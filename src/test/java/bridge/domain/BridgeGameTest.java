package bridge.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame game = new BridgeGame(new FakeBridge(List.of()));
    GameResult result = new GameResult(List.of(), true);

    @Test
    void 입력값이_U혹은D가_아니면_예외를_발생시킨다() {
        //given
        String move = "A";
        //when
        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> game.move(move, result));
    }
}
