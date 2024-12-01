package use_case.query;

import java.util.ArrayList;

/**
 * Output Data for the ShowProfile Use case.
 */
public class QueryOutputData {

    private final String username;
    private final ArrayList<Integer> RankHistory;
    private final boolean useCaseSucceeded;

    public QueryOutputData(String username, ArrayList<Integer> RankHistory, boolean useCaseSucceeded) {
        this.username = username;
        this.RankHistory = RankHistory;
        this.useCaseSucceeded = useCaseSucceeded;
    }

    public int getRankHistory() {
        return RankHistory;
    }

    public String getUsername() {
        return username;
    }

}
