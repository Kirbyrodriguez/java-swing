

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class firstGUI implements ActionListener,ItemListener {
    String possibleAnswer[] = {"It's certain.", "Most likely", "Ask again later", "Don't count on it", "Outlook not so good"};
    Random random = new Random();
    JTextField questionTextField;
    JLabel answerLabel;
    JLabel instructionLabel;
    JButton askMeButton;
    JFrame applicationFrame;
    String answer = "--";
    JPanel mainPanel;
    String instruction = "Type your question here:";

    public firstGUI() {
        mainPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);

        mainPanel.setLayout(boxLayout);
        applicationFrame = new JFrame("My magic 8 ball");

        applicationFrame.setSize(600, 400);
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        instructionLabel = new JLabel(instruction);
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(instructionLabel);

        questionTextField = new JTextField(50);
        questionTextField.setMaximumSize(new Dimension(500, 25));
        mainPanel.add(questionTextField);

        mainPanel.add(Box.createVerticalStrut(140));

        answerLabel = new JLabel(answer);
        answerLabel.setMinimumSize(new Dimension(1000, 1000));
        answerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(answerLabel);

        mainPanel.add(Box.createVerticalStrut(23));

        askMeButton = new JButton("Ask me");
        askMeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        askMeButton.addActionListener(this);
        mainPanel.add(askMeButton);

        JButton askMeButton2 = new JButton("Ask me again");
        askMeButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        askMeButton2.addActionListener(this);
        mainPanel.add(askMeButton2);

        JCheckBox checkBox = new JCheckBox("Sample questions");
        checkBox.addActionListener(this);
        mainPanel.add(Box.createRigidArea(new Dimension(checkBox.getPreferredSize().width,0)));
        mainPanel.add(Box.createRigidArea(new Dimension(10,0)));
        mainPanel.add(checkBox);
        applicationFrame.add(mainPanel);
        applicationFrame.setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand().equals("Ask me")) {
                answerLabel.setText(possibleAnswer[random.nextInt(possibleAnswer.length)]);
            }
            else if (e.getActionCommand().equals("Ask me again")){
                answerLabel.setText("Stop");
            }
        }
        @Override
        public void itemStateChanged(ItemEvent e){
        JCheckBox jc = (JCheckBox) e.getItem();
        boolean selected = jc.isSelected();
        if (selected){
            answerLabel.setText("JEJE");
        }

        }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new firstGUI();
            }
        });
    }
}
