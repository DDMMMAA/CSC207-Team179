package entity;

public class Board {
    private ChessPiece[][] grid;

    public Board() {
        grid = new ChessPiece[8][8];
    }

    public boolean isEmpty(int x, int y) {
        return grid[x][y] == null;
    }

    public ChessPiece getPiece(int x, int y) {
        return grid[x][y];
    }
}
