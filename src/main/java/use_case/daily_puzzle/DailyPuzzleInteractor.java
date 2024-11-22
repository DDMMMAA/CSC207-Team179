package use_case.daily_puzzle;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * The daily puzzle interactor.
 */
public class DailyPuzzleInteractor {
    private static final String LICHESS_URL = "https://lichess.org/api/puzzle/daily";
    private static final String TOKEN = "token";
    private final DailyPuzzleOutputBoundary puzzlePresenter;

    public DailyPuzzleInteractor(DailyPuzzleOutputBoundary dailyPuzzleOutputBoundary) {
        this.puzzlePresenter = dailyPuzzleOutputBoundary;
    }

    public static String getToken() {
        return System.getenv(TOKEN);
    }

    /**
     * Executes the use case.
     * @throws RuntimeException if API request fails.
     */
    public void execute() {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();
        final Request request = new Request.Builder().url(LICHESS_URL).build();
        final JSONObject output;

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());

            System.out.println(responseBody);
            output = responseBody;
            // placeholder, actual will call the view to make a board with the JSON.
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }

        final DailyPuzzleOutputData outputData = new DailyPuzzleOutputData(output, false);
        // fail checks/generating erorr message will come later, just want to see it works first
        puzzlePresenter.prepareSuccessView(outputData);

    }
}
