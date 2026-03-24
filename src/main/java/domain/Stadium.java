package domain;

import java.util.List;

public interface Stadium {
    public void participateWithNames(List<String> names);

    public void startGame(int numberOfGames);

    public void announceWinnerNames();
}
