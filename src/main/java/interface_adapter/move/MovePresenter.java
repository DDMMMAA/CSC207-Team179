package interface_adapter.move;

//import chariot.model.MoveInfo;
import interface_adapter.ViewManagerModel;
import use_case.move.MoveInputdata;
import use_case.move.MoveOutputBoundary;
import use_case.move.MoveOutputdata;

/**
 * The presenter for Move use case.
 */
public class MovePresenter implements MoveOutputBoundary {
    private final MoveViewModel moveViewModel;
    private final ViewManagerModel viewManagerModel;

    public MovePresenter(MoveViewModel moveViewModel, ViewManagerModel viewManagerModel) {
        this.moveViewModel = moveViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareMove(MoveOutputdata input) {
        // present the moved chess board
    }

    public void prepareSelect(MoveOutputdata input) {
        // present the select chess board
    }

}
