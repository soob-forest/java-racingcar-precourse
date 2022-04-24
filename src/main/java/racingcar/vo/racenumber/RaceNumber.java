package racingcar.vo.racenumber;

import racingcar.common.error.ErrorMessage;

public class RaceNumber {
    public static final int MIN = 0;
    public static final int MAX = 9;

    private int number;

    private RaceNumber(int number) {
        this.number = number;
        validate();
    }

    public static RaceNumber from(int number) {
        return new RaceNumber(number);
    }

    private void validate() {
        if (this.number < MIN || this.number > MAX) {
            throw new IllegalArgumentException(ErrorMessage.MSG_INVALID_NUMBER.getMessage());
        }
    }
}
