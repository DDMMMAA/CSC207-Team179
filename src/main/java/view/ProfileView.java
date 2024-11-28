package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.showProfile.ShowProfileState;
import interface_adapter.showProfile.ShowProfileViewModel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observer;

/**
 * The view of user profile.
 */
public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "showProfile";
    private final ShowProfileViewModel showProfileViewModel;

    private final JLabel username;
    private final JLabel currentRankPoint;

    public ProfileView(ViewManagerModel viewManagerModel, ShowProfileViewModel showProfileViewModel) {
        this.showProfileViewModel = showProfileViewModel;
        this.showProfileViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        final JLabel rankPointInfo = new JLabel("Current rank point: ");
        currentRankPoint = new JLabel();

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(rankPointInfo);
        this.add(currentRankPoint);
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
        final ShowProfileState showProfileState = (ShowProfileState) evt.getNewValue();
        username.setText(showProfileState.getUsername());
        currentRankPoint.setText(String.valueOf(showProfileState.getRankPoint()));
    }

    public String getViewName() {
        return viewName;
    }

}
