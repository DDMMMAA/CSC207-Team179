package entity;

import java.util.List;
import java.util.ArrayList;

public abstract class ChessPiece {
    private String color;
    private List<Integer> position;

    public ChessPiece(String color, int x, int y) {
        this.color = color;
        position.add(x);
        position.add(y);
    }

    public abstract List<int[]> getValidMoves(Board board);

    public String getColor() {
        return color;
    }

    public List<Integer> getPosition() {
        return this.position;
    }
}
