package use_case.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData loginoutputdata);

    void prepareFailView(String errorMessage);
}
