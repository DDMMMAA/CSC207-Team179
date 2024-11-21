package use_case.daily_puzzle;

/**
 * The output boundary for the Daily Puzzle Use case.
 */
public interface DailyPuzzleOutputBoundary {

    /**
     * Prepares the success view for the daily puzzle use case.
     * @param outputData The puzzle's JSON file
     */
    void prepareSuccessView(DailyPuzzleOutputData outputData);

    /**
     * Prepares the fail view for the daily puzzle use case.
     * @param errorMessage Explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
