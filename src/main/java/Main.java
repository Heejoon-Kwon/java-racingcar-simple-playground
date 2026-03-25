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

        List<String> participantNames = carRaceInput.nameInputs();
        int numberOfRounds = carRaceInput.numberInputs();

        try {
            race.joinWithNames(participantNames);
        } catch (RuntimeException e) {
            System.out.println("이미 시작된 경주입니다.");
        }
        carRaceOutput.showRace(race, numberOfRounds);
        carRaceOutput.showWinnerNames(race);
    }
}
