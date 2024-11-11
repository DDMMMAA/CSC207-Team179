package entity;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    public Rook(String color, int x, int y) {
        super(color, x, y);
    }

    public List<int[]> getValidMoves(Board board) {
        final List<int[]> validMoves = new ArrayList<>();
        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];

        for (int i = y - 1; i >= 02; i--) {
            validMoves.add(new int[] {x, i}); // Move upwards in the column
        }
        for (int i = y + 1; i < 8; i++) {
            validMoves.add(new int[] {x, i}); // Move downwards in the column
        }

        for (int i = x - 1; i >= 0; i--) {
            validMoves.add(new int[] {i, y}); // Move left in the row
        }
        for (int i = x + 1; i < 8; i++) {
            validMoves.add(new int[] {i, y}); // Move right in the row
        }
        return validMoves;
    }
}