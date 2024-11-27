package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.move.MoveController;
import interface_adapter.move.MoveViewModel;

/**
 * The view of actual chess game.
 */
public class ChessBoardView extends JPanel implements ActionListener, PropertyChangeListener {

    private final int numRow = 8;
    private final int numCol = 8;
    private final int fontSize = 36;
    private final String viewName = "Chess Board";
    private final MoveViewModel moveViewModel;
    private MoveController moveController;

    public ChessBoardView(MoveViewModel moveViewModel, MoveController moveController) {
        this.moveViewModel = moveViewModel;
        this.moveController = moveController;
        moveViewModel.addPropertyChangeListener(this);

        final JLabel titleLabel = new JLabel(MoveViewModel.TITLE_LABEL);

        this.setLayout(new GridLayout(numRow, numCol));

        // Add buttons to the frame in a chessboard pattern
        for (int row = 0; row < numRow; row++) {
            for (int col = 0; col < numCol; col++) {
                final JButton button = new JButton();
                final String stringRow = String.valueOf(Math.abs(row - 7));
                final String stringCol = String.valueOf(col);
                button.setActionCommand(stringCol + "," + stringRow);

                // Set background color to alternate between black and white
                if ((row + col) % 2 == 0) {
                    button.setBackground(Color.WHITE);
                }
                else {
                    button.setBackground(Color.BLACK);
                }

                // Add pieces to the board
                final String[][] pieces = moveViewModel.getPieces();
                if (pieces[row][col] != null) {
                    // Set highlighted background color associate with valid moves.
                    if (pieces[row][col].equals("Valid")) {
                        button.setBackground(Color.YELLOW);
                    }
                    else {
                        button.setText(pieces[row][col]);
                        button.setFont(new Font("Serif", Font.BOLD, fontSize));
                    }
                }

                button.setFocusPainted(true);
                button.addActionListener(this);
                this.add(button);

            }
        }

    }

    public void setMoveController(MoveController moveController) {
        this.moveController = moveController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
