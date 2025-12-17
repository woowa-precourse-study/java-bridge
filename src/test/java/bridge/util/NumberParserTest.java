package bridge.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class NumberParserTest {

    @Test
    void 숫자가_아닌_문자_입력시_예외_발생() {
        //given
        String input = "";
        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberParser.parse(input))
                .withMessageContaining("숫자가 아닙니다.");
    }
}
