package use_case.login;

import entity.User;

public class LoginUserDataAccessInterface {

    boolean existsByName(String username);

    void save(User user);

    User get(String username);

    void setCurrentUser(String name);

    String getCurrentUser();
}
