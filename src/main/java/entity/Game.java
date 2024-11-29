package entity;

public class Game {
    private final Board board;
    private final String currentPlayer;
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

    public ChessPiece getChesspiece_to_move() {
        return chesspiece_to_move;
    }

    public void setChesspiece_to_move(ChessPiece chesspiece_to_move) {
        this.chesspiece_to_move = chesspiece_to_move;
    }

    public void switchMode() {
        if (selectMode) {
            selectMode = false;
        }
        else {
            selectMode = true;
        }
    }

    public boolean getGameMode() {
        return selectMode;
    }

    public Board getBoard() {
        return board;
    }


}
