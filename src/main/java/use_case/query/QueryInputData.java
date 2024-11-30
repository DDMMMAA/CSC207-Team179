package use_case.query;

/**
 * The Input Data for the SearchUser use case.
 */

public class QueryInputData {
    private final String username;

    public QueryInputData(String username) {
        this.username = username; }

    public String getUsername() {
        return username; }
}
