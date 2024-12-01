package use_case.query;

import java.util.ArrayList;

/**
 * Output Data for the ShowProfile Use case.
 */
public class QueryOutputData {

    private final String username;
    private final ArrayList<Integer> rankHistory;
    private final boolean useCaseSucceeded;

    public QueryOutputData(String username, ArrayList<Integer> rankHistory, boolean useCaseSucceeded) {
        this.username = username;
        this.rankHistory = rankHistory;
        this.useCaseSucceeded = useCaseSucceeded;
    }

    public ArrayList<Integer> getRankHistory() {
        return rankHistory;
    }

    public String getUsername() {
        return username;
    }

}
