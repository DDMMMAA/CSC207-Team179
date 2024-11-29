package use_case.move;
import entity.Game;

/**
 * Input data for move use case.
 */
public class MoveInputdata {
    private final int[] position;

    public MoveInputdata(int[] input) {
        this.position = input;
    }

    public int[] getPosition() {
        return position;
    }
}

