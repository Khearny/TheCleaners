package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Tavern extends JPanel{
    
    //Buttons
    public JButton backButton;
    public JButton playGameButton;
    public JButton drinkButton;

    //Panel
    public Tavern(Image tavernImage, Image panelImage, Image buttonImage) {
        setPreferredSize(new Dimension(960, 720));
        setLayout(null);
        setOpaque(false);
        this.tavernImage = tavernImage;

        JPanel downPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(panelImage, 0, 0, 960, 100, this);
            }
        };
        downPanel.setBounds(0, 575, 960, 100);
        downPanel.setOpaque(false);
        downPanel.setLayout(null);


        backButton = createButton("GO TO CITY =>", 625, 25, buttonImage);
        drinkButton = createButton("DRINK (25 C)", 390, 25, buttonImage);
        playGameButton = createButton("PLAY GAME (50 C)", 150, 25, buttonImage);

        
        //Add Comps
        downPanel.add(backButton);
        downPanel.add(drinkButton);
        downPanel.add(playGameButton);
        add(downPanel);
    }
    
    //Button Creation Method
    private JButton createButton(String text, int x, int y, Image buttonImage) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 200, 50);
        ImageIcon rs = new ImageIcon(buttonImage.getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        btn.setIcon(rs);
        btn.setForeground(Color.white);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(true);
        return btn;
    }

    private Image tavernImage;
    
    //Draw
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tavernImage, 0, 0, 960, 720, this);
    }
}
