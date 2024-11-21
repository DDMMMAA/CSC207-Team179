package interface_adapter.move;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the MoveView.
 */
public class MoveViewModel extends ViewModel<MoveState> {

    public static final String TITLE_LABEL = "Move View";

    private final String[][] pieces = {
            {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"}, // Black major pieces
            {"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"}, // Black pawns
            {null, null, null, null, null, null, null, null}, // Empty row
            {null, null, null, null, null, null, null, null}, // Empty row
            {null, null, null, null, null, null, null, null}, // Empty row
            {null, null, null, null, null, null, null, null}, // Empty row
            {"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"}, // White pawns
            {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"}  // White major pieces
    };

    public MoveViewModel() {
        super("move");
        setState(new MoveState());
    }

    public String[][] getPieces() {
        return pieces;
    }
}
