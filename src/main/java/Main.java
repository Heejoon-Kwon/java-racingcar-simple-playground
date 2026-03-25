import domain.CarRaceInput;
import domain.CarRace;
import domain.Race;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Race race = new CarRace();
        CarRaceInput carRaceInput = new CarRaceInput();

        List<String> names = carRaceInput.nameInputs();
        int numberOfRounds = carRaceInput.numberInputs();

        race.joinWithNames(names);
        race.runRounds(numberOfRounds);
        race.announceWinnerNames();
    }
}
