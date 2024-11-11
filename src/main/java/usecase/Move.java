package usecase;

public class Move {
    private entity.Board board;
    private entity.Game game;

    public Move(entity.Board board, entity.Game game) {
        this.board = board;
        this.game = game;
    }

    public boolean move() {
        //updates the board if a valid move
    }
}
