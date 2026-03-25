package domain;

import java.util.List;

public interface Race {
    public void joinWithNames(List<String> names);

    public void runRounds(int numberOfGames);

    public void announceWinnerNames();
}
