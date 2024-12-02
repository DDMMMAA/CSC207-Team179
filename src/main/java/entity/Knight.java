package entity;

import java.util.ArrayList;

/**
 * Knight piece.
 */
public class Knight extends ChessPiece {
    public Knight(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    public ArrayList<int[]> getValidMoves() {
        // to be implemented
        return null;
    }
}
