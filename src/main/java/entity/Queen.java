package entity;

import java.util.ArrayList;

public class Queen extends ChessPiece {
    public Queen(String color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Returns all possible moves for a bishop from the given position on an 8x8 chessboard.
     *
     * @param position the position of the current piece
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    public ArrayList<int[]> getValidMoves() {
        final ArrayList<int[]> validMoves = new ArrayList<>();
        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];

        //yet to be implemented

        return validMoves;
    }
}