package Game;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    
    public CustomBar healthBar;
    public CustomBar manaBarFill;
    public JLabel licenceTick;

    public SidePanel(Image panelImage, Image barBorder, Image healthFill, Image staminaFill, Image licenceImage, Image licenceTickImage) {
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
        
        JLabel licence = new JLabel();
        ImageIcon rsLicenceImage = new ImageIcon(licenceImage.getScaledInstance(75, 100, Image.SCALE_SMOOTH));
        licence.setIcon(rsLicenceImage);
        licence.setOpaque(false);
        licence.setBounds(50, 300, 75, 100);
        
        licenceTick = new JLabel();
        ImageIcon rsLicenceTickImage = new ImageIcon(licenceTickImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        licenceTick.setIcon(rsLicenceTickImage);
        licenceTick.setOpaque(false);
        licenceTick.setVisible(false);
        licenceTick.setBounds(65, 340, 50, 50);
        
        healthBar = new CustomBar(healthFill, barBorder);
        healthBar.setBounds(40, 75, 225, 50);

        manaBarFill = new CustomBar(staminaFill, barBorder);
        manaBarFill.setBounds(40, 160, 225, 50);    

        add(healthText);
        add(manaText);
        add(healthBar);
        add(manaBarFill);
        add(licenceTick);
        add(licence);
    }

    private Image panelImage;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(panelImage, 0, 0, getWidth(), getHeight(), this);
    }
}
