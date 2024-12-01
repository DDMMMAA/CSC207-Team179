package use_case.logged_in;

/**
 * Input Boundary for actions which are related to signing up.
 */
public interface LoggedInInputBoundary {
    /**
     * Executes the switch to login view use case.
     */
    void switchToSignUpView();
}
