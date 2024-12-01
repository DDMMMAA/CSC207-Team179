package interface_adapter.query;

import interface_adapter.ViewModel;

import java.util.ArrayList;

/**
 * The View Model for the query view.
 */
public class QueryViewModel extends ViewModel<QueryState> {

    public QueryViewModel() {
        super("Query");
        setState(new QueryState());
    }

    public String getUsername() {
        return getState().getUsername();
    }

    public ArrayList<Integer> getRankHistory() {
        return getState().getRankHistory();
    }
}
