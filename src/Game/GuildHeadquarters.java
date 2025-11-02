package Game;

import javax.swing.*;
import java.awt.*;

public class GuildHeadquarters extends JPanel {

    public JButton backButton;
    public JButton getLicenceButton;
    public JButton learnSkillsButton;

    public GuildHeadquarters(){}
    
    //Guild Headquarters Scene
    public GuildHeadquarters(Image guildImage, Image panelImage, Image buttonImage) {
        setPreferredSize(new Dimension(960, 720));
        setLayout(null);
        setOpaque(false);
        this.guildImage = guildImage;

        
        //Draw Down Panel In The Scene
        JPanel downPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(panelImage, 0, 0, 960, 100, this);
            }
        };
        downPanel.setBounds(0, 575, 960, 100);
        downPanel.setOpaque(false);
        downPanel.setLayout(null);
        
        //Scene Button
        backButton = createButton("GO TO CITY =>", 625, 25, buttonImage);
        learnSkillsButton = createButton("LEARN SKILLS (100 C)", 390, 25, buttonImage);
        getLicenceButton = createButton("GET LICENCE (200 C)", 150, 25, buttonImage);

        //Add
        downPanel.add(backButton);
        downPanel.add(learnSkillsButton);
        downPanel.add(getLicenceButton);
        add(downPanel);
    }

    private Image guildImage;

    //Create Button Function
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

    //Draws Image
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(guildImage, 0, 0, 960, 720, this);
    }
}