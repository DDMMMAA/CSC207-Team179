package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.ChessDataAccessObject;
import data_access.UserDataAccessObject;
import data_access.QueryDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.query.QueryViewModel;
import interface_adapter.showProfile.ShowProfileViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;

/**
 * Main that activates login page.
 */
public class MainChessAPP {

    /**
     * The main method for starting the program with an external database used to persist user data.
     * @param args input to main
     */
    public static void main(String[] args) {

        final JFrame frame = new JFrame("Chess Game Login");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final CardLayout cardLayout = new CardLayout();
        final JPanel views = new JPanel(cardLayout);
        frame.add(views);

        final ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        final LoginViewModel loginViewModel = new LoginViewModel();
        final LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        final SignupViewModel signupViewModel = new SignupViewModel();
        final ShowProfileViewModel showProfileViewModel = new ShowProfileViewModel();
        final QueryViewModel queryViewModel = new QueryViewModel();

        final UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        final QueryDataAccessObject queryDataAccessObject = new QueryDataAccessObject();
        final SignupView signupView = SignupApp.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        final LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
                loggedInViewModel, userDataAccessObject, signupViewModel);
        final LoggedInView loggedInView = ShowProfileUseCaseFactory.create(viewManagerModel, loggedInViewModel,
                signupViewModel, showProfileViewModel, userDataAccessObject);
                showProfileViewModel, queryViewModel, userDataAccessObject, queryDataAccessObject);
        final ProfileView profileView = new ProfileView(viewManagerModel, showProfileViewModel);
        //        final LoggedInView loggedInView = new LoggedInView(viewManagerModel, loggedInViewModel);
        final QueryView queryView = new QueryView(viewManagerModel, queryViewModel);

        views.add(signupView, signupView.getViewName());
        views.add(loginView, loginView.getViewName());
        views.add(loggedInView, loggedInView.getViewName());
        views.add(profileView, profileView.getViewName());
        views.add(queryView, queryView.getViewName());

        final ChessAppBuilder chessAppBuilder = new ChessAppBuilder();
        chessAppBuilder.addChessDAO(new ChessDataAccessObject())
                .addMoveView()
                .addMoveUseCase();

        final ChessBoardView chessBoardView = chessAppBuilder.buildChessBoardView();
        views.add(chessBoardView, "chessBoardView");

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }
}
