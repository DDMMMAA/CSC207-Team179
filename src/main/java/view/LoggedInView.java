package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.query.QueryController;
import interface_adapter.showProfile.ShowProfileController;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JLabel passwordErrorField = new JLabel();

    private final JLabel username;

    private final JButton logOut;

    private final JTextField passwordInputField = new JTextField(15);
    private final JButton startChess;
    private final JButton showProfile;
    private final JButton showRankHistory;
    private final ShowProfileController showProfileController;

    public LoggedInView(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel,
                        ShowProfileController showProfileController) {
        this.loggedInViewModel = loggedInViewModel;
        this.showProfileController = showProfileController;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        final JPanel buttons = new JPanel();
        logOut = new JButton("Log Out");
        buttons.add(logOut);

        showRankHistory = new JButton("Show Rank History");

        showProfile = new JButton("Show Profile");

        startChess = new JButton("Start Chess Game");
        buttons.add(startChess);
        buttons.add(showProfile);
        buttons.add(showRankHistory);

        logOut.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        startChess.addActionListener(
                evt -> {
                    if (evt.getSource().equals(startChess)) {
                        viewManagerModel.setState("chessBoardView");
                        viewManagerModel.firePropertyChanged();
                    }
                }
        );

        showProfile.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(showProfile)) {
                            final LoggedInState currentState = loggedInViewModel.getState();

                            showProfileController.execute(
                                    currentState.getUsername()
                            );
                        }
                    }
                }
        );

        showRankHistory.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(showRankHistory)) {
                            final LoggedInState currentState = loggedInViewModel.getState();

                            QueryController.execute(
                                    currentState.getUsername()
                            )
                        }
                    }
                }
        )

        this.add(title);
        this.add(usernameInfo);
        this.add(username);

        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }

    public String getViewName() {
        return viewName;
    }
}
