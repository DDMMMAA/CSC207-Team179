package use_case.showProfile;

import java.util.ArrayList;

/**
 * Output Data for the ShowProfile Use case.
 */
public class ShowProfileOutputData {

    private final ArrayList<Integer> rankPointHistory;
    private final boolean useCaseSucceeded;

    public ShowProfileOutputData(ArrayList<Integer> rankPointHistory, boolean useCaseSucceeded) {
        this.rankPointHistory = rankPointHistory;
        this.useCaseSucceeded = useCaseSucceeded;
    }

    public ArrayList<Integer> getRankPointHistory() {
        return rankPointHistory;
    }

}
