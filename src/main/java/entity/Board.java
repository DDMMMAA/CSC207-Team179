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
     * @param col Column of tile
     * @param row Row of tile
     * @return bool
     */
    public boolean isEmpty(int col, int row) {
        return grid[col][row] == null;
    }

    /**
     * Returns the chess piece at a given tile.
     * @param col Column of tile
     * @param row Row of tile
     * @return Chesspiece
     */
    public ChessPiece getPiece(int col, int row) {
        return grid[col][row];
    }

}
