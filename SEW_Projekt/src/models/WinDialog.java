package models;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinDialog extends JDialog {
    private Image image;
    private static final String IMAGE_PATH = "../images/Win.jpg";
    private JTextField nickField;


    public WinDialog() {
        setTitle("Du hast gewonnen!");
        setResizable(false);
        setModal(true);


        image = new ImageIcon(getClass().getResource(IMAGE_PATH)).getImage();

        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                if (image == null)
                    return;

            }
        };

        JPanel newScorePanel = new JPanel();

      

        newScorePanel.setOpaque(false);
        mainPanel.add(newScorePanel, BorderLayout.SOUTH);
        add(mainPanel);

        pack();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
