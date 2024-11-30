package use_case.query;

/**
 * Input Boundary for actions which are related to searching user.
 */
public interface QueryInputBoundary {

    /**
     * Executes the search User use case.
     * @param username the input data
     */
    void execute(String username);

    /**
     * Executes the switch to login view use case.
     */
    void switchToLoginView();
}