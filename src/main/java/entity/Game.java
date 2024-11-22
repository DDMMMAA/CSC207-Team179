package entity;

public class Game {
    private Board board;
    private String currentPlayer;
    private boolean gameOver;
    private boolean whiteTurn; //if whiteturn is false, then its blacks turn
    private boolean selectMode; //if select mode is false, game is in movemode.
    private ChessPiece chesspiece_to_move;

    public Game(Board board, boolean whiteTurn) {
        this.board = board;
        this.currentPlayer = null;
        this.gameOver = false;
        this.whiteTurn = whiteTurn;
        this.selectMode = true;
        this.chesspiece_to_move = null;
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
