package entity;

import java.util.ArrayList;

public abstract class ChessPiece {
    private String color;
    private ArrayList<Integer> position;

    public ChessPiece(String color, int x, int y) {
        this.color = color;
        position.add(x);
        position.add(y);
    }

    public abstract ArrayList<int[]> getValidMoves(Board board);

    public String getColor() {
        return color;
    }

    public ArrayList<Integer> getPosition() {
        return this.position;
    }
}
