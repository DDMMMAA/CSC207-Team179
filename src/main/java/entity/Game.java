package entity;

public class Game {
    private Board board;
    private String currentPlayer;
    private boolean gameOver;
    private boolean whiteTurn;

    public Game(Board board, boolean whiteTurn) {
        this.board = board;
        this.currentPlayer = null;
        this.gameOver = false;
        this.whiteTurn = whiteTurn;
    }

    public void switchTurn() {
        if (whiteTurn) {
            whiteTurn = false;
        }
        else {
            whiteTurn = true;
        }
    }

    public String getCurrentPlayer() {
        if (currentPlayer == null) {
            return "No Player Selected";
        }
        else {
            return currentPlayer;
        }
    }
}
