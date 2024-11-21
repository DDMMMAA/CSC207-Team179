package view;

import interface_adapter.move.MoveController;
import interface_adapter.move.MoveViewModel;

import javax.swing.*;
import java.awt.*;


public class ChessBoardViewTest {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test ChessBoardView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        MoveViewModel TestModel = new MoveViewModel();
        MoveController TestController = new MoveController();

        ChessBoardView TestView = new ChessBoardView(TestModel, TestController);

        frame.add(TestView);
        frame.setVisible(true);

    }
}
