package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VehicleRace implements Race {
    private static final int RANDOM_INT_UPPER_BOUND = 10;

    private final List<Participant> participants;

    public VehicleRace() {
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
            participant.moveForward(generateRandomInt());
        }
    }

    private int generateRandomInt() {
        Random random = new Random();

        return random.nextInt(RANDOM_INT_UPPER_BOUND);
    }

    @Override
    public List<String> getWinnerNames() {
        List<Participant> winners = new ArrayList<>();

        for(Participant participant : this.participants) {
            checkWinnerOrNot(winners, participant);
        }
        return winners.stream().map(Participant::getName).toList();
    }

    private void checkWinnerOrNot(List<Participant> winners, Participant candidate) {
        if (winners.isEmpty()) {
            winners.add(candidate);
            return;
        }

        if (winners.get(0).getDistance() == candidate.getDistance()) {
            winners.add(candidate);
        }

        if (winners.get(0).getDistance() < candidate.getDistance()) {
            winners.clear();
            winners.add(candidate);
        }
    }
}
