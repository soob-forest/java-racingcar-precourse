package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.factory.CarsFactory;
import racingcar.factory.RaceRandomNumberFactory;
import racingcar.view.input.Input;
import racingcar.view.output.Output;

public class RacingCarController {
    private Output outputView;
    private Input inputView;

    public RacingCarController(Output outputView, Input inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        try {
            Cars cars = participateCars();
            race(cars);
            paradeWinningCars(cars);
        } catch (Exception exception) {
            outputView.printError(exception);
        }

    }

    private Cars participateCars() {
        outputView.enterCarName();
        return CarsFactory.fromNames(Arrays.asList(inputView.enterCarName()));
    }

    private void paradeWinningCars(Cars cars) {
        List<String> winningCarName = new ArrayList<>();
        for (Car winningCar : cars.getWinningCars()) {
            winningCarName.add(winningCar.getName().getName());
        }
        outputView.winningCars(winningCarName);
    }

    private void race(Cars cars) {
        outputView.enterTryNumber();
        int raceCount = inputView.enterTryNumber();
        outputView.runResultMessage();
        for (int count = 0; count < raceCount; count++) {
            move(cars);
        }
    }

    private void move(Cars cars) {
        for (Car car : cars.getParticipatedCars()) {
            car.move(RaceRandomNumberFactory.create());
            outputView.racingResult(car.getName().getName(), car.getDistance().getDistance());
        }
        outputView.racingResultDelimiter();
    }
}
