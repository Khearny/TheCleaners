package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Map extends JPanel{
    
    public JButton guildHeadquartersButton;
    public JButton blacksmithButton;
    public JButton tavernButton;
    public JButton portalButton;
    
    public Map(Image map, Image buttonImage) {
        setPreferredSize(new Dimension(960, 720));
        setLayout(null);
        setOpaque(false);

        this.mapImage = map;
        this.buttonImage = buttonImage;

        guildHeadquartersButton = createButton("GUILD HEADQUARTERS", 700, 300);
        blacksmithButton = createButton("BLACKSMITH", 175, 100);
        tavernButton = createButton("TAVERN", 400, 125);
        portalButton = createButton("GO TO PORTAL =>", 700, 600);

        add(guildHeadquartersButton);
        add(blacksmithButton);
        add(tavernButton);
        add(portalButton);
    }

    private Image mapImage;
    private Image buttonImage;
    
    private JButton createButton(String text, int x, int y) {
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);
    }
    
}
