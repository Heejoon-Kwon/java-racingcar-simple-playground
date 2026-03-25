package domain;

import java.util.List;

public class CarRaceOutput {
    public void showDistance(String name, int distance) {
        System.out.println(name + " : " + "-".repeat(distance));
    }

    public void showRoundStart() {
        System.out.println("실행결과");
    }

    public void endLine() {
        System.out.println();
    }

    public void showWinnerNames(List<String> nameList) {
        String name = String.join(", ", nameList);
        System.out.println(name + "가 최종 우승했습니다.");
    }
}
