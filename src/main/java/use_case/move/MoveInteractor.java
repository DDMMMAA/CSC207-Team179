package use_case.move;

/**
 * Move interactor who handles the business logic of move.
 */
public class MoveInteractor implements MoveInputBoundary {
    private entity.Game game;

    public MoveInteractor(entity.Game game) {
        this.game = game;
    }

    public boolean isvalidmove() {
        // check if this move is valid
    }

    @Override
    public void handleClick(MoveInputdata position) {
        // Starting point of this class

    }
}
