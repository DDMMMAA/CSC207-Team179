package interface_adapter.query;

import interface_adapter.ViewManagerModel;
import use_case.query.QueryOutputBoundary;
import use_case.query.QueryOutputData;
import view.ViewManager;

public class QueryPresenter implements QueryOutputBoundary {

    private final QueryViewModel queryViewModel;
    private final ViewManagerModel viewManagerModel;

    public QueryPresenter(QueryViewModel queryViewModel, ViewManagerModel viewManagerModel) {
        this.queryViewModel = queryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(QueryOutputData outputData) {
        // On success, switch to the Profile view.

        final QueryState queryState = queryViewModel.getState();
        queryState.setUsername(outputData.getUsername());
        this.queryViewModel.setState(queryState);
        this.queryViewModel.firePropertyChanged();

        this.viewManagerModel.setState(queryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
