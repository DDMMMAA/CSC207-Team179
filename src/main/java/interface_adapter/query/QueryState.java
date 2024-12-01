package interface_adapter.query;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

/**
 * The State information representing the logged-in user.
 */
public class QueryState {
    private String username = "";

    public QueryState() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Integer> getRankHistory() {
        return rankHistory;
    }
}
