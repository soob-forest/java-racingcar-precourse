package racingcar.vo.racenumber;

public class RaceNumber {

    public static final String MSG_INVALID_NUMBER = "같은 이름의 차를 만들 수 없습니다.";

    private static final int MIN = 0;
    private static final int MAX = 9;

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
            throw new IllegalArgumentException(MSG_INVALID_NUMBER);
        }
    }
}
