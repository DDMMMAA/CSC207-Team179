package entity;

import java.util.ArrayList;

/**
 * King piece.
 */
public class King extends ChessPiece {
    public King(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public ArrayList<int[]> getValidMoves() {
        // to be implemented
        return null;
    }
}
