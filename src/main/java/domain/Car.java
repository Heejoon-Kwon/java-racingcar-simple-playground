package domain;


public class Car implements Participant {
    private final String name;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void moveForward(int luck) {
        if (luck >= 4) {
            distance += 1;
        }
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
