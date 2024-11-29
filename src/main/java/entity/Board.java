package entity;

import org.json.JSONObject;

/**
 * The chess board entity.
 */
public class Board {
    private ChessPiece[][] grid;

    public Board() {
        grid = new ChessPiece[8][8];
    }

    public Board(JSONObject boardFile) {
        // will call some other method to read the file, placeholder for now.
    }

    /**
     * Returns if a tile is empty.
     * @param position position of piece
     * @return bool
     */
    public boolean isEmpty(int[] position) {
        return grid[position[1]][position[0]] == null;
    }

    /**
     * Returns the chess piece at a given tile.
     * @param position position of piece
     * @return Chesspiece
     */
    public ChessPiece getPiece(int[] position) {
        return grid[position[1]][position[0]];
    }

    public void clear(int[] position) {
        grid[position[1]][position[0]] = null;
    }

    public void moveToLocation(int[] position, ChessPiece piece) {
        clear(piece.getPosition());
        grid[position[1]][position[0]] = piece;
    }

}
