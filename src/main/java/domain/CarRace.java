package domain;

import exception.IllegalRequestException;
import view.CarRaceOutput;

import java.util.ArrayList;
import java.util.List;


public class CarRace implements Race {
    private final List<Participant> participants;

    private boolean isStarted;

    public CarRace() {
        participants = new ArrayList<>();
        isStarted = false;
    }


    @Override
    public void joinWithNames(List<String> names) {
        if (isStarted) {
            throw new IllegalRequestException("Already started!");
        }

        participants.addAll(names.stream().map(Car::new).toList());
    }

    @Override
    public List<Participant> getParticipants() {
        return participants;
    }

    @Override
    public void startOneRound() {
        isStarted = true;
        for (Participant participant : participants) {
            participant.moveForward();
        }
    }

    @Override
    public List<String> getWinnerNames() {
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
        return winners.stream().map(Participant::getName).toList();
    }
}
