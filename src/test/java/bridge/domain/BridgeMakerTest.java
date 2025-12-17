package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import bridge.domain.numbergenerator.UpperNumberGenerator;
import bridge.exception.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    private BridgeMaker maker = new BridgeMaker(new UpperNumberGenerator());

    @Test
    void 다리를_생성하는_로직_테스트() {
        //given
        int size = 3;
        //when
        List<String> bridge = maker.makeBridge(size);
        //then
        assertThat(bridge)
                .hasSize(size)
                .contains("U")
                .doesNotContain("D");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 22})
    void 다리_크기는_3이상_20이하_여야_한다(int size) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> maker.makeBridge(size))
                .withMessageContaining(ErrorMessage.NOT_VALID_BRIDGE_SIZE.getMessage());
    }
}
