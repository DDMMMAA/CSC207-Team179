package entity;

import org.json.JSONObject;

/**
 * The chess board entity.
 */
public class Board {
    private ChessPiece[][] grid;

    public Board() {
        ChessPiece[][] grid = new ChessPiece[8][8];

        grid[0][0] = new Rook("White", 0, 0);
        grid[0][1] = new Knight("White", 0, 1);
        grid[0][2] = new Bishop("White", 0, 2);
        grid[0][3] = new Queen("White", 0, 3);
        grid[0][4] = new King("White", 0, 4);
        grid[0][5] = new Bishop("White", 0, 5);
        grid[0][6] = new Knight("White", 0, 6);
        grid[0][7] = new Rook("White", 0, 7);
        for (int i = 0; i < 8; i++) {
            grid[1][i] = new Pawn("White", 1, i);
        }

        grid[7][0] = new Rook("Black", 7, 0);
        grid[7][1] = new Knight("Black", 7, 1);
        grid[7][2] = new Bishop("Black", 7, 2);
        grid[7][3] = new Queen("Black", 7, 3);
        grid[7][4] = new King("Black", 7, 4);
        grid[7][5] = new Bishop("Black", 7, 5);
        grid[7][6] = new Knight("Black", 7, 6);
        grid[7][7] = new Rook("Black", 7, 7);
        for (int i = 0; i < 8; i++) {
            grid[6][i] = new Pawn("Black", 6, i);
        }

// Set all empty squares to null
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                grid[row][col] = null;
            }
        }
        this.grid = grid;
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
        return grid[position[0]][position[1]] == null;
    }

    /**
     * Returns the chess piece at a given tile.
     * @param position position of piece
     * @return Chesspiece
     */
    public ChessPiece getPiece(int[] position) {
        return grid[position[0]][position[1]];
    }


    public void moveToLocation(int[] position, ChessPiece piece) {
        grid[piece.getPosition()[0]][piece.getPosition()[1]] = null;
        piece.setPosition(position);
        grid[position[0]][position[1]] = piece;
    }

}
