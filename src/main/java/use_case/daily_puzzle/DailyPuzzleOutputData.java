package use_case.daily_puzzle;

import org.json.JSONObject;

/**
 * Output data for the daily puzzle use case.
 */
public class DailyPuzzleOutputData {

    private final JSONObject puzzle;

    private final boolean useCaseFailed;

    public DailyPuzzleOutputData(JSONObject puzzle, boolean useCaseFailed) {
        this.puzzle = puzzle;
        this.useCaseFailed = useCaseFailed;
    }

    public JSONObject getPuzzle() {
        return puzzle;
    }
    // could change later to be board and this or the interactor will call for board generation.
}
