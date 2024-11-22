package interface_adapter.logged_in;

import interface_adapter.ViewManagerModel;

/**
 * The Presenter for the Change Password Use Case.
 */
public class LoggedInPresenter {

    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoggedInPresenter(ViewManagerModel viewManagerModel,
                             LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    public void prepareLoggedInView(String username) {
        final LoggedInState state = loggedInViewModel.getState();
        state.setUsername(username);
        loggedInViewModel.setState(state);
        loggedInViewModel.firePropertyChanged();

    }

    public void prepareFailView(String error) {
        loggedInViewModel.setState(new LoggedInState());
        loggedInViewModel.firePropertyChanged();
    }
}
