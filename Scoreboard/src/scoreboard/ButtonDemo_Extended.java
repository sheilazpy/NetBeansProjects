package scoreboard;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author rockyross
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class ButtonDemo_Extended implements ActionListener {

    // Definition of global values and items that are part of the GUI.
    int leftScoreAmount = 0;
    int rightScoreAmount = 0;
    String leftName, rightName;
    JPanel leftPanel, rightPanel;
    JLabel leftLabel, rightLabel, leftScore, rightScore;
    JButton leftPlus1, leftPlus2, leftPlus3, leftMinus1, rightPlus1, rightPlus2,
            rightPlus3, rightMinus1, resetButton;

    public JPanel createContentPane() {

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        // Creation of a Panel to contain the title labels
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        leftPanel.setLocation(0, 0);
        leftPanel.setSize(140, 160);
        totalGUI.add(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        rightPanel.setLocation(140, 0);
        rightPanel.setSize(140, 160);
        totalGUI.add(rightPanel);

        leftLabel = new JLabel(leftName);
        leftLabel.setLocation(10, 0);
        leftLabel.setSize(120, 30);
        leftLabel.setHorizontalAlignment(0);
        leftPanel.add(leftLabel);

        rightLabel = new JLabel(rightName);
        rightLabel.setLocation(10, 0);
        rightLabel.setSize(120, 30);
        rightLabel.setHorizontalAlignment(0);
        rightPanel.add(rightLabel);

        leftScore = new JLabel("" + leftScoreAmount);
        leftScore.setLocation(10, 40);
        leftScore.setSize(120, 30);
        leftScore.setHorizontalAlignment(0);
        leftPanel.add(leftScore);

        rightScore = new JLabel("" + rightScoreAmount);
        rightScore.setLocation(10, 40);
        rightScore.setSize(120, 30);
        rightScore.setHorizontalAlignment(0);
        rightPanel.add(rightScore);

        // We create a button and manipulate it using the syntax we have
        // used before. Now each button has an ActionListener which posts
        // its action out when the button is pressed.
        leftPlus1 = new JButton("+ 1");
        leftPlus1.setLocation(10, 80);
        leftPlus1.setSize(55, 30);
        leftPlus1.addActionListener(this);
        leftPanel.add(leftPlus1);

        leftPlus2 = new JButton("+ 2");
        leftPlus2.setLocation(75, 80);
        leftPlus2.setSize(55, 30);
        leftPlus2.addActionListener(this);
        leftPanel.add(leftPlus2);

        leftPlus3 = new JButton("+ 3");
        leftPlus3.setLocation(10, 120);
        leftPlus3.setSize(55, 30);
        leftPlus3.addActionListener(this);
        leftPanel.add(leftPlus3);

        leftMinus1 = new JButton("- 1");
        leftMinus1.setLocation(75, 120);
        leftMinus1.setSize(55, 30);
        leftMinus1.addActionListener(this);
        leftPanel.add(leftMinus1);

        rightPlus1 = new JButton("+ 1");
        rightPlus1.setLocation(10, 80);
        rightPlus1.setSize(55, 30);
        rightPlus1.addActionListener(this);
        rightPanel.add(rightPlus1);

        rightPlus2 = new JButton("+ 2");
        rightPlus2.setLocation(75, 80);
        rightPlus2.setSize(55, 30);
        rightPlus2.addActionListener(this);
        rightPanel.add(rightPlus2);

        rightPlus3 = new JButton("+ 3");
        rightPlus3.setLocation(10, 120);
        rightPlus3.setSize(55, 30);
        rightPlus3.addActionListener(this);
        rightPanel.add(rightPlus3);

        rightMinus1 = new JButton("- 1");
        rightMinus1.setLocation(75, 120);
        rightMinus1.setSize(55, 30);
        rightMinus1.addActionListener(this);
        rightPanel.add(rightMinus1);

        resetButton = new JButton("Reset Score");
        resetButton.setLocation(10, 170);
        resetButton.setSize(260, 30);
        resetButton.addActionListener(this);
        totalGUI.add(resetButton);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // This is the new ActionPerformed Method.
    // It catches any events with an ActionListener attached.
    // Using an if statement, we can determine which button was pressed
    // and change the appropriate values in our GUI.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftPlus1) {
            leftScoreAmount = leftScoreAmount + 1;
        } else if (e.getSource() == leftPlus2) {
            leftScoreAmount = leftScoreAmount + 2;
        } else if (e.getSource() == leftPlus3) {
            leftScoreAmount = leftScoreAmount + 3;
        } else if (e.getSource() == leftMinus1 && leftScoreAmount > 0) {
            leftScoreAmount = leftScoreAmount - 1;
        } else if (e.getSource() == rightPlus1) {
            rightScoreAmount = rightScoreAmount + 1;
        } else if (e.getSource() == rightPlus2) {
            rightScoreAmount = rightScoreAmount + 2;
        } else if (e.getSource() == rightPlus3) {
            rightScoreAmount = rightScoreAmount + 3;
        } else if (e.getSource() == rightMinus1 && rightScoreAmount > 0) {
            rightScoreAmount = rightScoreAmount - 1;
        } else if (e.getSource() == resetButton) {
            leftScoreAmount = 0;
            rightScoreAmount = 0;
        }
        leftScore.setText("" + leftScoreAmount);
        rightScore.setText("" + rightScoreAmount);
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JButton Scores! [=]");

        //Create and set up the content pane.
        ButtonDemo_Extended demo = new ButtonDemo_Extended();
        demo.leftName = JOptionPane.showInputDialog("Team 1 Name: ");
        demo.rightName = JOptionPane.showInputDialog("Team 2 Name: ");
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 240);
        frame.setVisible(true);
    }

    public void startButtonExtended() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}