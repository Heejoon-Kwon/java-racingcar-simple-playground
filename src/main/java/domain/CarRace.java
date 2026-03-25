package domain;

import java.util.ArrayList;
import java.util.List;


public class CarRace implements Race {
    private final List<Participant> participants;

    public CarRace() {
        participants = new ArrayList<>();
    }


    @Override
    public void joinWithNames(List<String> names) {
        participants.addAll(names.stream().map(Car::new).toList());
    }

    @Override
    public List<Participant> getParticipants() {
        return participants;
    }

    @Override
    public void startOneRound() {
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
