package entity;

import java.util.ArrayList;
/**
 * The abstract class of all chess piece.
 */
public abstract class ChessPiece {
    private final String color;
    private int[] position;

    public ChessPiece(String color, int x, int y) {
        this.color = color;
        this.position = new int[2];
        position[0] = x;
        position[1] = y;
    }

    /**
     * The abstract class for getting the valid moves of a piece.
     */
    public abstract ArrayList<int[]> getValidMoves();

    public String getColor() {
        return color;
    }

    public int[] getPosition() {
        return this.position;
    }
}
