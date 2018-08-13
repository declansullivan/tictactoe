/**
 * Declan Sullivan
 * TicTacToe.java
 * 
 * 5/16/18
 * dhsulliv@ucsd.edu
 * cs11sfn
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Basic window creation knowledge mostly learned from Oracle's ActionListener
 * documentation.
 */

public class TicTacToe extends JFrame implements ActionListener {


    private int button_count = 0;
    private int layoutSize = 3;
    private int move = 0;
    private String winner;

    private JButton[][] buttons;
    private Font font;
    private Font hidden;

    public static void main(String args[]) {
        TicTacToe window = new TicTacToe("Tic-Tac-Toe // Declan Sullivan");
    }

    public TicTacToe(String name) {
        super(name);
        setLayout(new GridLayout(layoutSize, layoutSize));
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buttons = new JButton[layoutSize][layoutSize];

        hidden = new Font("SERIF", 0, 0);
        font = new Font("SERIF", 0, 100);

        for (int rows = 0; rows < layoutSize; rows++) {
            for (int cols = 0; cols < layoutSize; cols++) {
                buttons[rows][cols] = new JButton();
                buttons[rows][cols].addActionListener(this);
                buttons[rows][cols].setText(Integer.toString(button_count++));
                buttons[rows][cols].setFont(hidden);
                add(buttons[rows][cols]);
            }
        }

        setVisible(true);
    }

    public String checkWin() {

        for (int idx = 0; idx < layoutSize; idx++) {
            if (buttons[idx][0].getText().equals(buttons[idx][1].getText()) &&
                buttons[idx][1].getText().equals(buttons[idx][2].getText())) 
                return buttons[idx][0].getText();
            if (buttons[0][idx].getText().equals(buttons[1][idx].getText()) && 
                buttons[1][idx].getText().equals(buttons[2][idx].getText())) 
                return buttons[0][idx].getText();
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()))
            return buttons[1][1].getText();
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()))
            return buttons[1][1].getText();

        return " ";
    }

    public void actionPerformed(ActionEvent e) {
        if (move++ % 2 == 0) ((AbstractButton) e.getSource()).setText("X");
        else ((AbstractButton) e.getSource()).setText("O");

        ((AbstractButton) e.getSource()).setFont(font);
        ((AbstractButton) e.getSource()).setEnabled(false);

        winner = checkWin();

        if (!winner.equals(" ")) {
            for (int row = 0; row < layoutSize; row++) {
                for (int col = 0; col < layoutSize; col++) {
                    buttons[row][col].setEnabled(false);
                }
            }

            buttons[1][1].setText(winner + " won!");
            buttons[1][1].setFont(new Font("SERIF", 0, 50));
        }
    }
}