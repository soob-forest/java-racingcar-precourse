package racingcar.vo.racenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.error.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceNumberTest {

    @ParameterizedTest(name = "일부터 구 범위 정상  [{arguments}]")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void 일_부터_구_범위_정상(int number) {
        assertThat(RaceNumber.from(number));
    }

    @ParameterizedTest(name = "일 부터 구 범위 예외  [{arguments}]")
    @ValueSource(ints = {-10, -1, 10, 100})
    public void 일_부터_구_범위_예외(int number) {
        assertThatThrownBy(() -> RaceNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MSG_INVALID_NUMBER.getMessage());
    }
}