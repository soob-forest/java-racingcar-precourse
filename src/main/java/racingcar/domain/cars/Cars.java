package racingcar.domain.cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.common.error.ErrorMessage;
import racingcar.domain.car.Car;
import racingcar.domain.car.Distance;
import racingcar.factory.RaceRandomNumberFactory;
import racingcar.vo.racecount.RaceCount;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void participate(Car newCar) {
        validateDuplicatedName(newCar);
        cars.add(newCar);
    }

    public void raceRepeat(RaceCount raceCount) {
        for (int count = 0; count < raceCount.toInteger(); count++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(RaceRandomNumberFactory.create());
        }
    }

    public List<Car> getParticipatedCars() {
        return Collections.unmodifiableList(new ArrayList<>(cars));
    }

    public List<Car> getWinningCars() {

        List<Distance> distances = new ArrayList<>();
        for (Car car : cars) {
            distances.add(car.getDistance());
        }
        distances.sort(Comparator.reverseOrder());

        Distance maxDistance = distances.get(0);

        List<Car> winningCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance().equals(maxDistance)) {
                winningCars.add(car);
            }
        }
        return Collections.unmodifiableList(new ArrayList<>(winningCars));
    }

    private void validateDuplicatedName(Car newCar) {
        if (this.cars.contains(newCar)) {
            throw new IllegalStateException(ErrorMessage.MSG_DUPLICATE_NAME.getMessage());
        }
    }
}
