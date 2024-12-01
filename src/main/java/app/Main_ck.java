package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.ChessDataAccessObject;
import data_access.UserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.showProfile.ShowProfileViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;

/**
 * Main that activates login page.
 */
public class Main_ck {

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

        final UserDataAccessObject userDataAccessObject = new UserDataAccessObject();

        final SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        final LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
                loggedInViewModel, userDataAccessObject);
        final LoggedInView loggedInView = ShowProfileUseCaseFactory.create(viewManagerModel, loggedInViewModel,
                signupViewModel, showProfileViewModel, userDataAccessObject);
        final ProfileView profileView = new ProfileView(viewManagerModel, showProfileViewModel);
        //        final LoggedInView loggedInView = new LoggedInView(viewManagerModel, loggedInViewModel);

        views.add(signupView, signupView.getViewName());
        views.add(loginView, loginView.getViewName());
        views.add(loggedInView, loggedInView.getViewName());
        views.add(profileView, profileView.getViewName());

        final CK_ChessAppBuilder chessAppBuilder = new CK_ChessAppBuilder();
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
