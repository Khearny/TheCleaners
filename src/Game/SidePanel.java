package Game;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    
    //Buttons and Bars
    public CustomBar healthBar;
    public CustomBar manaBar;
    public JLabel licenceTick;
    public JLabel equipmentTick;
    public JLabel skillsTick;
    public JLabel coinText;
    public JLabel happinessText;

    //Panel
    public SidePanel(Image panelImage, Image barBorder, Image healthFill, Image staminaFill, Image licenceImage, Image tickImage, Image coinImage, Image equipmentImage, Image happinessImage, Image skillsImage) {
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
        
        JLabel equipment = new JLabel();
        ImageIcon rsEquipmentImage = new ImageIcon(equipmentImage.getScaledInstance(75, 100, Image.SCALE_SMOOTH));
        equipment.setIcon(rsEquipmentImage);
        equipment.setOpaque(false);
        equipment.setBounds(200, 300, 75, 100);
        
        JLabel coin = new JLabel();
        ImageIcon rsCoinImage = new ImageIcon(coinImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        coin.setIcon(rsCoinImage);
        coin.setOpaque(false);
        coin.setBounds(50, 550, 50, 50);
        
        JLabel happiness = new JLabel();
        ImageIcon rsHapinessImage = new ImageIcon(happinessImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        happiness.setIcon(rsHapinessImage);
        happiness.setOpaque(false);
        happiness.setBounds(50, 450, 50, 50);
        
        JLabel skills = new JLabel();
        ImageIcon rsSkillsImage = new ImageIcon(skillsImage.getScaledInstance(75, 75, Image.SCALE_SMOOTH));
        skills.setIcon(rsSkillsImage);
        skills.setOpaque(false);
        skills.setBounds(200, 450, 75, 75);
        
        coinText = new JLabel(Integer.toString(PlayerData.playerCoin));
        coinText.setForeground(Color.WHITE);
        coinText.setFont(new Font("Serif", Font.BOLD, 36));
        coinText.setBounds(150, 555, 250, 30);
        
        happinessText = new JLabel(Integer.toString(PlayerData.playerHappiness) + "%");
        happinessText.setForeground(Color.WHITE);
        happinessText.setFont(new Font("Serif", Font.BOLD, 36));
        happinessText.setBounds(110, 455, 250, 30);
        
        licenceTick = new JLabel();
        ImageIcon rsLicenceTickImage = new ImageIcon(tickImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        licenceTick.setIcon(rsLicenceTickImage);
        licenceTick.setOpaque(false);
        licenceTick.setVisible(false);
        licenceTick.setBounds(65, 340, 50, 50);
        
        equipmentTick = new JLabel();
        ImageIcon rsEquipmentTickImage = new ImageIcon(tickImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        equipmentTick.setIcon(rsEquipmentTickImage);
        equipmentTick.setOpaque(false);
        equipmentTick.setVisible(false);
        equipmentTick.setBounds(210, 340, 50, 50);
        
        skillsTick = new JLabel();
        ImageIcon rsSkillsTickImage = new ImageIcon(tickImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        skillsTick.setIcon(rsSkillsTickImage);
        skillsTick.setOpaque(false);
        skillsTick.setVisible(false);
        skillsTick.setBounds(210, 460, 50, 50);
        
        healthBar = new CustomBar(healthFill, barBorder);
        healthBar.setBounds(40, 75, 225, 50);
        healthBar.setValue(PlayerData.playerHealth);

        manaBar = new CustomBar(staminaFill, barBorder);
        manaBar.setBounds(40, 160, 225, 50);
        manaBar.setValue(PlayerData.playerMana);

        //Adding Comps
        add(healthBar);
        add(manaBar);
        add(licenceTick);
        add(equipmentTick);
        add(skillsTick);
        
        add(healthText);
        add(manaText);
        add(licence);
        add(equipment);
        add(coin);
        add(coinText);
        add(happiness);
        add(happinessText);
        add(skills);
    }

    private Image panelImage;

    //Draaw
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(panelImage, 0, 0, getWidth(), getHeight(), this);
    }
}
