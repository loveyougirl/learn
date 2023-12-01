package state;

public class TestLift {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(new ClosingState(lift));
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
