package models;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import listener.ExitListener;


public class InGameLayout extends JPanel {
    private JLabel attemptsLabel;
    private JLabel timeLabel;
    private JLabel zeitLabel;
    private JButton playPauseButton;
    private ImageIcon playIcon;
    private ImageIcon pauseIcon;
    private static boolean pause;
    private List<CardModel> cards;
    private static GameTimer timer;

    public InGameLayout(List<CardModel> cards) {
        this.cards = cards;

        setOpaque(false);
        setLayout(new BorderLayout());

        playPauseButton = new JButton();
        playIcon = new ImageIcon(getClass().getResource("../images/play.png"));
        pauseIcon = new ImageIcon(getClass().getResource("../images/pause.png"));

        creatingPanel();

        pause = false;
        timer = new GameTimer(this);
        timer.start();
    }

    public void creatingPanel() {
        addAttemptsLabel();
        addTimeLabelStyle();

      

        addButton(playPauseButton, "pause.png", (event) ->
        {
            pause = !pause;
            if (pause) {
                timer.setTimeRunning(false);
                GameEngine.setPlaying(false);

                playPauseButton.setIcon(playIcon);

                for (CardModel card : cards)
                    card.setEnabled(false);
            } else {
                timer.setTimeRunning(true);
                GameEngine.setPlaying(true);

                playPauseButton.setIcon(pauseIcon);

                for (CardModel card : cards)
                    if (!card.isClicked())
                        card.setEnabled(true);
            }
        });

        

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 190, 0));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(playPauseButton);
       

        add(buttonsPanel, BorderLayout.LINE_END);
    }

    public void addAttemptsLabel() {
        attemptsLabel = new JLabel();

        attemptsLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
        attemptsLabel.setText("Versuche: 00");
        attemptsLabel.setBorder(new EmptyBorder(0, 200, 40, 50));
        attemptsLabel.setOpaque(false);

        attemptsLabel.setForeground(Color.BLACK);

        add(attemptsLabel, BorderLayout.LINE_START);
    }


    public void addTimeLabelStyle() {
      
        zeitLabel = new JLabel();
        
   
        
        timeLabel = new JLabel();
        timeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setOpaque(false);
        timeLabel.setBorder(new EmptyBorder(0, 0, 40, 0));
        
        timeLabel.setText("00:00");

        add(timeLabel, BorderLayout.CENTER);
    }

    public void addButton(JButton button, String iconName, ActionListener listener) {
        button.setIcon(new ImageIcon(getClass().getResource("../images/" + iconName)));

        button.setBackground(Color.BLACK);
        button.setBorder(new EmptyBorder(0, 5, 15, 10));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(listener);
        button.setOpaque(false);
    }

    public List<CardModel> getCards() {
        return cards;
    }

    public void setTimeLabelText(String text) {
        timeLabel.setText(text);
    }

    public void setAttemptsLabelText(String text) {
        attemptsLabel.setText("Versuche: " + text);
        attemptsLabel.setBackground(Color.BLACK);
    }

    public static GameTimer getTimer() {
        return timer;
    }

    public static boolean isPause() {
        return pause;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 90);
    }
}
