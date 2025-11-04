package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Dungeon extends JPanel{
    //Buttons and Bars
    public CustomBar enemyHealthBar;
    public JButton swordAttackButton;
    public JButton voidAttackButton;
    public JButton shieldButton;
    public JButton passButton;
    
    //Dungeon Frame
    public Dungeon(Image dungeonImage, Image panelImage, Image buttonImage, Image playerImage, Image enemyImage, Image healthFill, Image barBorder){
        setPreferredSize(new Dimension(960, 720));
        setLayout(null);
        setOpaque(false);
        this.dungeonImage = dungeonImage;
        
        JPanel downPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(panelImage, 0, 0, 960, 100, this);
            }
        };
        downPanel.setBounds(0, 575, 960, 100);
        downPanel.setOpaque(false);
        downPanel.setLayout(null);
        
        JLabel enemy = new JLabel();
        ImageIcon rsEnemyImage = new ImageIcon(enemyImage.getScaledInstance(200, 400, Image.SCALE_SMOOTH));
        enemy.setIcon(rsEnemyImage);
        enemy.setOpaque(false);
        enemy.setBounds(100, 150, 200, 400);
        
        JLabel player = new JLabel();
        ImageIcon rsPlayerImage = new ImageIcon(playerImage.getScaledInstance(200, 400, Image.SCALE_SMOOTH));
        player.setIcon(rsPlayerImage);
        player.setOpaque(false);
        player.setBounds(600, 150, 200, 400);
        
        
        enemyHealthBar = new CustomBar(healthFill, barBorder);
        enemyHealthBar.setBounds(100, 50, 225, 50);
        enemyHealthBar.setValue(EnemyData.enemyHealth);
        
        swordAttackButton = createButton("SLASH [20DMG] [-20M]", 100, 25, buttonImage);
        voidAttackButton = createButton("VOID [40DMG] [-40M]", 300, 25, buttonImage);
        shieldButton = createButton("SHIELD [25HP] [-10M]", 500, 25, buttonImage);
        passButton = createButton("PASS [+25M]", 700, 25, buttonImage);
        
        //Add Comp
        downPanel.add(swordAttackButton);
        downPanel.add(voidAttackButton);
        downPanel.add(shieldButton);
        downPanel.add(passButton);
        add(enemyHealthBar);
        add(downPanel);
        add(player);
        add(enemy);
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
    
    private Image dungeonImage;
    
    //Draw
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(dungeonImage, 0, 0, 960, 720, this);
    }
    
}
