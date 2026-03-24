package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RaceTrack implements Stadium {
    private List<Player> players;

    private boolean isStarted;

    public RaceTrack() {
        players = new ArrayList<>();
    }


    @Override
    public void participateWithNames(List<String> names) {
        if (!isStarted) {
            players.addAll(names.stream().map(Car::new).toList());
        }
    }

    @Override
    public void startGame(int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("실행결과");
            allStart();
            System.out.println();
        }
    }

    private void allStart() {
        for (Player player : this.players) {
            player.tryToRun();
            System.out.println(player.getName() + " : " + "-".repeat(player.getDistance()));
        }
    }

    @Override
    public void announceWinnerNames() {
        List<Player> winners = new ArrayList<>();

        for(Player player : this.players) {
            if (winners.isEmpty()) {
                winners.add(player);
                continue;
            }

            if (winners.get(0).getDistance() == player.getDistance()) {
                winners.add(player);
            }

            if (winners.get(0).getDistance() < player.getDistance()) {
                winners.clear();
                winners.add(player);
            }
        }

        String winnerNames = winners.stream().map(Player::getName).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
