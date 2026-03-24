import domain.Listener;
import domain.RaceTrack;
import domain.Stadium;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stadium stadium = new RaceTrack();
        Listener listener = new Listener();

        List<String> nameList = listener.namesListener();
        int numberOfGames = listener.numberListener();

        stadium.participateWithNames(nameList);
        stadium.startGame(numberOfGames);
        stadium.announceWinnerNames();

    }
}
