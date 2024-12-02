package use_case.move;

import java.util.ArrayList;
import java.util.Arrays;

import entity.ChessPiece;
import entity.Game;


/**
 * Move interactor who handles the business logic of move.
 */
public class MoveInteractor implements MoveInputBoundary {
    private final MoveDataAccessInterface moveDataAccessObject;
    private final MoveOutputBoundary moveOutPutBoundary;
    private final Game game;

    public MoveInteractor(MoveDataAccessInterface moveDataAccessObject,
                          MoveOutputBoundary moveOutPutBoundary,
                          Game game) {
        this.moveDataAccessObject = moveDataAccessObject;
        this.moveOutPutBoundary = moveOutPutBoundary;
        this.game = game;
    }

    /**
     * Return a list of valid moves based on the chess game.
     * @param chessPiece the piece
     */
    private ArrayList<int[]> validmoves(ChessPiece chessPiece) {
        ArrayList<int[]> full_list;
        full_list = chessPiece.getValidMoves();
        //reduce full_list to a limited list based on the game, still to be implented
        return full_list;
    }

    @Override
    public void execute(MoveInputdata position) {
        final int[] pos = position.getPosition();
        if (game.getGameMode()) {
            select(pos);
        }
        else if (game.getBoard().getPiece(pos) != null) {
            if (game.getBoard().getPiece(pos).getColor().equals(game.getChesspiece_to_move().getColor())) {
                select(pos);
            }
            else {
                move(pos);
            }
        }
        else {
            move(pos);
        }

    }

    /**
     * Executes the usecase when a piece is selected.
     * @param position the position of the selected piece.
     */
    private void select(int[] position) {
        final ChessPiece piece = game.getBoard().getPiece(position);
        if (piece == null) {
            //Nothing happends since no piece selected
            final MoveOutputdata nulldata = new MoveOutputdata(new ArrayList<>(), game.getBoard());
            moveOutPutBoundary.prepareMove(nulldata);
        }
        else {
            game.setChesspiece_to_move(piece);
            game.switchMode();
            final MoveOutputdata selectdata = new MoveOutputdata(validmoves(piece), game.getBoard());
            moveOutPutBoundary.prepareMove(selectdata);
        }
    }

    private void move(int[] pos) {
        final ArrayList<int[]> validmoves = validmoves(game.getChesspiece_to_move());
        if (containsArray(validmoves, pos)) {
            game.getBoard().moveToLocation(pos, game.getChesspiece_to_move()); //Move the chess piece to location
            final MoveOutputdata movedata = new MoveOutputdata(new ArrayList<>(), game.getBoard());
            moveOutPutBoundary.prepareMove(movedata);
            game.switchMode();
        }
        else {
            // Do Nothing since nothing happend
            final MoveOutputdata nulldata = new MoveOutputdata(new ArrayList<>(), game.getBoard());
            moveOutPutBoundary.prepareMove(nulldata);
            game.switchMode();

        }
    }

    public static boolean containsArray(ArrayList<int[]> list, int[] target) {
        if (list == null || target == null) {
            return false;
        }
        for (int[] array : list) {
            if (Arrays.equals(array, target)) {
                return true;
            }
        }
        return false;
    }
}
