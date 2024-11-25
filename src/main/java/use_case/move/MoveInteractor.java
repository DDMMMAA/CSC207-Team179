package use_case.move;

import entity.Game;
/**
 * Move interactor who handles the business logic of move.
 */
public class MoveInteractor implements MoveInputBoundary {
    private final MoveDataAccessInterface moveDataAccessObject;
    private final MoveOutPutBoundary moveOutPutBoundary;

    public MoveInteractor(MoveDataAccessInterface moveDataAccessObject,
                          MoveOutPutBoundary moveOutPutBoundary) {
        this.moveDataAccessObject = moveDataAccessObject;
        this.moveOutPutBoundary = moveOutPutBoundary;
    }

//    private boolean isvalidmove() {
//        // check if this move is valid
//    }

    @Override
    public void execute(MoveInputdata position) {
        // Starting point of this class

    }
}
