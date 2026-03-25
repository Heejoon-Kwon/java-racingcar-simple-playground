import exception.InvalidInputException;
import exception.InvalidNameInputException;
import exception.InvalidNumberInputException;
import view.CarRaceInput;
import domain.CarRace;
import domain.Race;
import view.CarRaceOutput;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Race race = new CarRace();
        CarRaceInput carRaceInput = new CarRaceInput();
        CarRaceOutput carRaceOutput = new CarRaceOutput();

        List<String> participantNames = carRaceInput.getNamesInput();
        int numberOfRounds = carRaceInput.getNumberInput();
        carRaceInput.turnOffScanner();

        race.joinWithNames(participantNames);
        carRaceOutput.showRace(race, numberOfRounds);
        carRaceOutput.showWinnerNames(race);
    }
}
