package entity;

import java.util.ArrayList;

/**
 * The representation of a password-protected user for our program.
 */
public class User {

    private final String name;
    private final String password;
    private ArrayList<Integer> rankPointHistory;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.rankPointHistory = new ArrayList<>();
        this.rankPointHistory.add(0);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Integer> getRankPointHistory() {
        return rankPointHistory;
    }

    /**
     * This method add latest rankPoint to the end of rankPointHistory.
     * @param rankPoint is the new rankPoint after one puzzle finished
     */
    public void addRankPointHistory(int rankPoint) {
        this.rankPointHistory.add(rankPoint);
    }

}
