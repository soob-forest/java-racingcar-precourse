package racingcar.factory;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vo.racenumber.RaceNumber;

public class RaceRandomNumberFactory {

    public static RaceNumber create() {
        return RaceNumber.from(Randoms.pickNumberInRange(RaceNumber.MIN, RaceNumber.MAX));
    }
}
