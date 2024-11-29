package entity;

import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(String color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Returns all possible moves for a bishop from the given position on an 8x8 chessboard.
     *
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    public ArrayList<int[]> getValidMoves() {
        final ArrayList<int[]> validMoves = new ArrayList<>();
        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];
        // Up-Left Diagonal
        int i = 1;
        while (x - i >= 0 && y - i >= 0) {
            validMoves.add(new int[]{x - i, y - i});
            i++;
        }

        // Up-Right Diagonal
        i = 1;
        while (x + i < 8 && y - i >= 0) {
            validMoves.add(new int[]{x + i, y - i});
            i++;
        }

        // Down-Left Diagonal
        i = 1;
        while (x - i >= 0 && y + i < 8) {
            validMoves.add(new int[]{x - i, y + i});
            i++;
        }

        // Down-Right Diagonal
        i = 1;
        while (x + i < 8 && y + i < 8) {
            validMoves.add(new int[]{x + i, y + i});
            i++;
        }

        return validMoves;
    }
}
