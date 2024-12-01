package interface_adapter.query;

import use_case.query.QueryInputBoundary;
import use_case.query.QueryInputData;

/**
 * The controller for the ShowProfile use case.
 */
public class QueryController {

    private final QueryInputBoundary QueryInputInteractor;

    public QueryController(QueryInputBoundary QueryInteractor) {
        this.QueryInputInteractor = QueryInteractor;
    }

    /**
     * Execute the showProfile use case.
     * @param username the username of the user logging in
     */
    public void execute(String username) {
        final QueryInputData queryInputData = new QueryInputData(username);

        QueryInputInteractor.execute(queryInputData);
    }
}

