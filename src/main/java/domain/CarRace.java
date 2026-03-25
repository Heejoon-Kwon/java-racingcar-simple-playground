package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CarRace implements Race {
    private final List<Participant> participants;

    private boolean isStarted;

    private final CarRaceOutput output;

    public CarRace() {
        participants = new ArrayList<>();
        isStarted = false;
        output = new CarRaceOutput();
    }


    @Override
    public void joinWithNames(List<String> names) {
        if (!isStarted) {
            participants.addAll(names.stream().map(Car::new).toList());
        }
    }

    @Override
    public void runRounds(int numberOfRounds) {
        isStarted = true;
        for (int i = 0; i < numberOfRounds; i++) {
            output.showRoundStart();
            allStart();
            output.endLine();
        }
    }

    private void allStart() {
        for (Participant participant : this.participants) {
            participant.moveForward();
            output.showDistance(participant.getName(), participant.getDistance());
        }
    }

    @Override
    public void announceWinnerNames() {
        List<Participant> winners = new ArrayList<>();

        for(Participant participant : this.participants) {
            if (winners.isEmpty()) {
                winners.add(participant);
                continue;
            }

            if (winners.get(0).getDistance() == participant.getDistance()) {
                winners.add(participant);
            }

            if (winners.get(0).getDistance() < participant.getDistance()) {
                winners.clear();
                winners.add(participant);
            }
        }

        output.showWinnerNames(winners.stream().map(Participant::getName).toList());
    }
}
