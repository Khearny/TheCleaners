package Game;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {

    public CustomBar healthBar;
    public CustomBar staminaBar;

    public SidePanel(Image panelImage, Image barBorder, Image healthFill, Image staminaFill) {
        setPreferredSize(new Dimension(320, 720));
        setOpaque(false);
        setLayout(null);
        this.panelImage = panelImage;
        
        JLabel healthText = new JLabel("HP");
        healthText.setForeground(Color.WHITE);
        healthText.setFont(new Font("Serif", Font.BOLD, 16));
        healthText.setBounds(145, 40, 250, 30);

        JLabel manaText = new JLabel("Mana");
        manaText.setForeground(Color.WHITE);
        manaText.setFont(new Font("Serif", Font.BOLD, 16));
        manaText.setBounds(135, 125, 250, 30);
        

        healthBar = new CustomBar(healthFill, barBorder);
        healthBar.setBounds(40, 75, 225, 50);

        staminaBar = new CustomBar(staminaFill, barBorder);
        staminaBar.setBounds(40, 160, 225, 50);

        add(healthText);
        add(manaText);
        add(healthBar);
        add(staminaBar);
    }

    private Image panelImage;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(panelImage, 0, 0, getWidth(), getHeight(), this);
    }
}
