package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.showProfile.ShowProfileController;
import interface_adapter.showProfile.ShowProfilePresenter;
import interface_adapter.showProfile.ShowProfileViewModel;
import use_case.showProfile.ShowProfileInputBoundary;
import use_case.showProfile.ShowProfileInteractor;
import use_case.showProfile.ShowProfileOutputBoundary;
import use_case.showProfile.ShowProfileUserDataAccessInterface;
import view.LoggedInView;

/**
 * This class contains the static factory function for creating the LoggedInView.
 */
public final class ShowProfileUseCaseFactory {

    /** Prevent instantiation. */
    private ShowProfileUseCaseFactory() {

    }

    /**
     * Factory function for creating the LoggedInView.
     *
     * @param viewManagerModel     the ViewManagerModel to inject into the LoggedInView
     * @param loggedInViewModel    the loggedInViewModel to inject into the LoggedInView
     * @param showProfileViewModel
     * @param userDataAccessObject the ChangePasswordUserDataAccessInterface to inject into the LoggedInView
     * @return the LoggedInView created for the provided input classes
     */
    public static LoggedInView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            ShowProfileViewModel showProfileViewModel,
            ShowProfileUserDataAccessInterface userDataAccessObject) {

        final ShowProfileController showProfileController =
                createShowProfileUseCase(viewManagerModel, loggedInViewModel,
                        showProfileViewModel, userDataAccessObject);

        return new LoggedInView(viewManagerModel, loggedInViewModel, showProfileController);

    }

    private static ShowProfileController createShowProfileUseCase(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            ShowProfileViewModel showProfileViewModel,
            ShowProfileUserDataAccessInterface userDataAccessObject) {

        final ShowProfileOutputBoundary showProfileOutputBoundary = new ShowProfilePresenter(showProfileViewModel,
                viewManagerModel);

        final ShowProfileInputBoundary showProfileInputInteractor = new ShowProfileInteractor(userDataAccessObject,
                showProfileOutputBoundary);

        return new ShowProfileController(showProfileInputInteractor);
    }
}
