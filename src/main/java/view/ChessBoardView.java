package view;

import java.awt.*;
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

    private final String viewName = "Chess Board";
    private final MoveViewModel moveViewModel;
    private MoveController moveController;

    public ChessBoardView(MoveViewModel moveViewModel, MoveController moveController) {
        this.moveViewModel = moveViewModel;
        this.moveController = moveController;
        moveViewModel.addPropertyChangeListener(this);

        final JLabel titleLabel = new JLabel(MoveViewModel.TITLE_LABEL);

        this.setLayout(new GridLayout(8, 8));

        // Add buttons to the frame in a chessboard pattern
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton();
                final String string_row = String.valueOf(Math.abs(row - 7));
                final String string_col = String.valueOf(col);
                button.setActionCommand(string_col + "," + string_row);

                // Set background color to alternate between black and white
                if ((row + col) % 2 == 0) {
                    button.setBackground(Color.WHITE);
                }
                else {
                    button.setBackground(Color.BLACK);
                }

                // Add pieces to the board
                String[][] pieces = moveViewModel.getPieces();
                if (pieces[row][col] != null) {
                    button.setText(pieces[row][col]);
                    button.setFont(new Font("Serif", Font.BOLD, 36));
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
