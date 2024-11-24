package interface_adapter.move;

import interface_adapter.ViewManagerModel;
import use_case.move.MoveOutPutBoundary;

/**
 * The presenter for Move use case.
 */
public class MovePresenter implements MoveOutPutBoundary {
    private final MoveViewModel moveViewModel;
    private final ViewManagerModel viewManagerModel;

    public MovePresenter(MoveViewModel moveViewModel, ViewManagerModel viewManagerModel) {
        this.moveViewModel = moveViewModel;
        this.viewManagerModel = viewManagerModel;
    }
}
