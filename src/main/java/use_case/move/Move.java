package use_case.move;

/**
 * Use case for moving a piece.
 */
public class Move {
    private entity.Game game;

    public Move(entity.Game game) {
        this.game = game;
    }

    /**
     * Returns whether move was successful.
     * @return bool
     */
    public boolean move() {
        return true;
        // updates the board if a valid move, currently placeholder
    }
}
