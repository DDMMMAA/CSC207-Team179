package app;

import data_access.ChessDataAccessObject;

/**
 * This is the main chess app.
 */
public class MainChessApp {

    /**
     * Main method.
     * @param args commandline arguments
     */
    public static void main(String[] args) {

        // TODO change to ChessDataAccessInterface once implemented
        final ChessDataAccessObject chessDataAccessObject = new ChessDataAccessObject();

        final ChessAppBuilder chessAppBuilder = new ChessAppBuilder();
        chessAppBuilder.addChessDAO(chessDataAccessObject)
                .addMoveView()
                .addMoveUseCase().build().setVisible(true);

    }
}
