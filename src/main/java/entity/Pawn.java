package entity;

import java.util.ArrayList;

public class Pawn extends ChessPiece {
    public Pawn(String color, int x, int y) {
        super(color, x, y);
    }

    /**
     * Returns all possible moves for a pawn from the given position on an 8x8 chessboard.
     * @return A list of int arrays, each representing a valid move [newX, newY].
     */
    public ArrayList<int[]> getValidMoves() {
        final ArrayList<int[]> validMoves = new ArrayList<>();
        final int x = this.getPosition()[0];
        final int y = this.getPosition()[1];

        if (this.getColor().equals("White") && x != 7) {
            validMoves.add(new int[]{x + 1, y + 1});
            validMoves.add(new int[]{x + 1, y - 1});
            validMoves.add(new int[]{x + 1, y});
        } else if (this.getColor().equals("Black") && x != 0) {
            validMoves.add(new int[]{x - 1, y - 1});
            validMoves.add(new int[]{x - 1, y });
            validMoves.add(new int[]{x - 1, y + 1});
        }
        validMoves.removeIf(move -> move[0] < 0 || move[1] < 0 || move[0] > 7 || move[1] > 7);

        return validMoves;
    }
}
