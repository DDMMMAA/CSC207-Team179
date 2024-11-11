package entity;

import java.util.List;
import java.util.ArrayList;

public abstract class ChessPiece {
    private String color;
    private int x;
    private int y;

    public ChessPiece(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract List<int[]> getValidMoves(Board board);

    public String getColor() {
        return color;
    }

    public int[] getPosition() {
        return new int[] {this.x, this.y};
    }
}
