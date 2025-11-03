package Game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Frame extends JFrame{
    
        //Game Icon
        Image icon = new ImageIcon(getClass().getResource("/Game/Resources/Icon.png")).getImage();
        
        //UI Image
        Image button = new ImageIcon(getClass().getResource("/Game/Resources/Button.png")).getImage();
        Image panel = new ImageIcon(getClass().getResource("/Game/Resources/Panel.png")).getImage();
        
        //Map Image
        Image map = new ImageIcon(getClass().getResource("/Game/Resources/Map.jpg")).getImage();
        
        //Inside Building Image
        Image guildHeadquarters = new ImageIcon(getClass().getResource("/Game/Resources/GuildHeadquarters.png")).getImage();
        Image blacksmith = new ImageIcon(getClass().getResource("/Game/Resources/Blacksmith.png")).getImage();
        Image portal = new ImageIcon(getClass().getResource("/Game/Resources/Portal.png")).getImage();
        Image tavern = new ImageIcon(getClass().getResource("/Game/Resources/Tavern.png")).getImage();
        Image dungeon = new ImageIcon(getClass().getResource("/Game/Resources/Dungeon.png")).getImage();
        
        //Side Bar Image
        Image barBorder = new ImageIcon(getClass().getResource("/Game/Resources/BarBorder.png")).getImage();
        Image healthBarFill = new ImageIcon(getClass().getResource("/Game/Resources/HealthBarFill.png")).getImage();
        Image manaBarFill = new ImageIcon(getClass().getResource("/Game/Resources/ManaBarFill.png")).getImage();
        Image licence = new ImageIcon(getClass().getResource("/Game/Resources/Licence.png")).getImage();
        Image licenceTick = new ImageIcon(getClass().getResource("/Game/Resources/LicenceTick.png")).getImage();
        Image coin = new ImageIcon(getClass().getResource("/Game/Resources/Coin.png")).getImage();
        Image equipment = new ImageIcon(getClass().getResource("/Game/Resources/Equipment.png")).getImage();
        Image happiness = new ImageIcon(getClass().getResource("/Game/Resources/Happiness.png")).getImage();
        Image skills = new ImageIcon(getClass().getResource("/Game/Resources/Skills.png")).getImage();
        
        //Characters
        Image player = new ImageIcon(getClass().getResource("/Game/Resources/Player.png")).getImage();
        Image enemy = new ImageIcon(getClass().getResource("/Game/Resources/Enemy.png")).getImage();
        
    Frame(){
        Random rand = new Random();
        PlayerData playerData = new PlayerData();
        EnemyData enemyData = new EnemyData();
        
        // --- Setup Panels ---
        Map mapPanel = new Map(map, button);
        SidePanel sidePanel = new SidePanel(panel, barBorder, healthBarFill, manaBarFill, licence, licenceTick, coin, equipment, happiness, skills);
        GuildHeadquarters guildPanel = new GuildHeadquarters(guildHeadquarters, panel, button);
        Blacksmith blacksmithPanel = new Blacksmith(blacksmith, panel, button);
        Portal portalPanel = new Portal(portal, panel, button);
        Tavern tavernPanel = new Tavern(tavern, panel, button);
        Dungeon dungeonPanel = new Dungeon(dungeon, panel, button, player, enemy, healthBarFill, barBorder);

        JPanel replaceablePanel = new JPanel(new CardLayout());
        replaceablePanel.add(mapPanel, "Map");
        replaceablePanel.add(guildPanel, "Guild Headquarters");
        replaceablePanel.add(blacksmithPanel, "Blacksmith");
        replaceablePanel.add(portalPanel, "Portal");
        replaceablePanel.add(tavernPanel, "Tavern");
        replaceablePanel.add(dungeonPanel, "Dungeon");

        CardLayout cl = (CardLayout) replaceablePanel.getLayout();
        cl.show(replaceablePanel, "Map");

        // --- Button actions ---
        mapPanel.guildHeadquartersButton.addActionListener(e -> cl.show(replaceablePanel, "Guild Headquarters"));
        mapPanel.blacksmithButton.addActionListener(e -> cl.show(replaceablePanel, "Blacksmith"));
        mapPanel.portalButton.addActionListener(e -> cl.show(replaceablePanel, "Portal"));
        mapPanel.tavernButton.addActionListener(e -> cl.show(replaceablePanel, "Tavern"));
        
        //Go Dungeon
        portalPanel.dungeonButton.addActionListener(e -> {
            if(playerData.getIsGetLicence() == true && playerData.getIsLearnSkill() == true && playerData.getIsLearnSkill() == true){
                cl.show(replaceablePanel, "Dungeon");
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                enemyData.setEnemyDamage();
                playerData.setPlayerHappiness(-10);
                sidePanel.happinessText.setText(Integer.toString(playerData.playerHappiness));
            }else{
                JOptionPane.showMessageDialog(this, "GET YOUR LICENCE AND EQUIPMENT AND LEARN SKILLS");
            }
        });
        
        guildPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        blacksmithPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        portalPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        tavernPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        
        guildPanel.getLicenceButton.addActionListener(e -> {
            if(playerData.getIsGetLicence() == false && playerData.getCoin() >= 200){
                playerData.setCoin(-200);
                sidePanel.coinText.setText(Integer.toString(playerData.playerCoin));
                playerData.setIsGetLicence(true);
                sidePanel.licenceTick.setVisible(true);
                guildPanel.getLicenceButton.setVisible(false);
                guildPanel.learnSkillsButton.setBounds(150, 25, guildPanel.learnSkillsButton.getWidth(), guildPanel.learnSkillsButton.getHeight());
            }else{
                JOptionPane.showMessageDialog(this, "YOU NEED COIN TO GET LICENCE");
            }
        });
        
        guildPanel.learnSkillsButton.addActionListener(e -> {
            if(playerData.getIsLearnSkill() == false && playerData.getCoin() >= 100){
                playerData.setCoin(-100);
                sidePanel.coinText.setText(Integer.toString(playerData.playerCoin));
                playerData.setIsLearnSkill(true);
                sidePanel.skillsTick.setVisible(true); 
                guildPanel.learnSkillsButton.setVisible(false);
                guildPanel.backButton.setBounds(390, 25, guildPanel.backButton.getWidth(), guildPanel.backButton.getHeight());
            }else{
                JOptionPane.showMessageDialog(this, "YOU NEED COIN TO LEARN SKILLS");
            }
        });
        
        blacksmithPanel.getEquipmetButton.addActionListener(e -> {
            if(playerData.getIsGetEquipment() == false && playerData.getCoin() >= 200){
                playerData.setCoin(-200);
                sidePanel.coinText.setText(Integer.toString(playerData.playerCoin));
                playerData.setIsGetEquipment(true);
                sidePanel.equipmentTick.setVisible(true);
                blacksmithPanel.getEquipmetButton.setVisible(false);
                blacksmithPanel.backButton.setBounds(390, 25, blacksmithPanel.backButton.getWidth(), blacksmithPanel.backButton.getHeight());
            }else{
                JOptionPane.showMessageDialog(this, "YOU NEED COIN TO GET EQUIPMENT");
            }
        });
        
        tavernPanel.drinkButton.addActionListener(e -> {
            if(playerData.getCoin() >= 25){
                playerData.setCoin(-25);
                sidePanel.coinText.setText(Integer.toString(playerData.playerCoin));
                playerData.setPlayerHealth(20);
                playerData.setPlayerMana(20);
                playerData.setPlayerHappiness(25);
                
                sidePanel.healthBar.setValue(PlayerData.playerHealth);
                sidePanel.manaBar.setValue(PlayerData.playerMana);
                sidePanel.happinessText.setText(Integer.toString(playerData.playerHappiness) + "%");
            }else{
                JOptionPane.showMessageDialog(this, "GET LOST!!!");
            }
        });
        
        tavernPanel.playGameButton.addActionListener(e -> {
            if(playerData.getCoin() >= 50){
                playerData.setCoin(-50);
                sidePanel.coinText.setText(Integer.toString(playerData.playerCoin));
                int randomNum = rand.nextInt(2);
                
                if(randomNum == 0){
                    JOptionPane.showMessageDialog(this, "Haha... You lost 50 C!");
                    playerData.setPlayerHappiness(-5);
                    sidePanel.happinessText.setText(Integer.toString(playerData.playerHappiness) + "%");
                }
                
                if(randomNum == 1){
                    JOptionPane.showMessageDialog(this, "Ahh... You won 100 C!");
                    playerData.setCoin(100);
                    sidePanel.coinText.setText(Integer.toString(playerData.playerCoin));
                    playerData.setPlayerHappiness(5);
                    sidePanel.happinessText.setText(Integer.toString(playerData.playerHappiness) + "%");
                }
            }else{
                JOptionPane.showMessageDialog(this, "NO MONEY, NO FUNNY");
            }
        });
        
        //Dungeon Fight Button Functions
        dungeonPanel.swordAttackButton.addActionListener(e -> {
            if(playerData.getPlayerMana() >= 20){
                enemyData.setEnemyHealth(-20);
                enemyData.setEnemyDamage();
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                playerData.setPlayerHealth(-enemyData.getEnemyDamage());
                playerData.setPlayerMana(-20);
                sidePanel.healthBar.setValue(playerData.getPlayerHealth());
                sidePanel.manaBar.setValue(playerData.getPlayerMana());
                JOptionPane.showMessageDialog(this, "YOU HIT 20 DAMAGE!! ENEMY HIT " + enemyData.getEnemyDamage() + " DAMAGE");
            }else{
                JOptionPane.showMessageDialog(this, "YOU DONT HAVE ENOUGH MANA!! USE OTHER SKILLS OR PASS");
            }
            
            if(enemyData.getEnemyHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU KILLED ENEMY!! EARNED 300 C");
                cl.show(replaceablePanel, "Map");
                enemyData.setEnemyHealth(100);
                playerData.setCoin(300);
                
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                sidePanel.coinText.setText(Integer.toString(playerData.getCoin()));
            }
            
            if(playerData.getPlayerHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU DEAD... TRY AGAIN");
                dispose();
                System.exit(0);
            }
        });
        
        dungeonPanel.voidAttackButton.addActionListener(e -> {
            if(playerData.getPlayerMana() >= 40){
                enemyData.setEnemyHealth(-40);
                enemyData.setEnemyDamage();
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                playerData.setPlayerHealth(-enemyData.getEnemyDamage());
                playerData.setPlayerMana(-40);
                sidePanel.healthBar.setValue(playerData.getPlayerHealth());
                sidePanel.manaBar.setValue(playerData.getPlayerMana());
                JOptionPane.showMessageDialog(this, "YOU HIT 40 DAMAGE!! ENEMY HIT " + enemyData.getEnemyDamage() + " DAMAGE");
            }else{
                JOptionPane.showMessageDialog(this, "YOU DONT HAVE ENOUGH MANA!! USE OTHER SKILLS OR PASS");
            }
            
            if(enemyData.getEnemyHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU KILLED ENEMY!! EARNED 300 C");
                cl.show(replaceablePanel, "Map");
                enemyData.setEnemyHealth(100);
                playerData.setCoin(300);
                
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                sidePanel.coinText.setText(Integer.toString(playerData.getCoin()));
            }
            
            if(playerData.getPlayerHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU DEAD... TRY AGAIN");
                dispose();
                System.exit(0);
            }
        });
        
        dungeonPanel.shieldButton.addActionListener(e -> {
            if(playerData.getPlayerMana() >= 10){
                enemyData.setEnemyHealth(0);
                enemyData.setEnemyDamage();
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                playerData.setPlayerHealth(15);
                playerData.setPlayerMana(-10);
                sidePanel.healthBar.setValue(playerData.getPlayerHealth());
                sidePanel.manaBar.setValue(playerData.getPlayerMana());
                JOptionPane.showMessageDialog(this, "YOU HIT 0 DAMAGE BUT YOU REGAIN 25 HP!! ENEMY HIT 0 DAMAGE BECAUSE YOU HAVE SHIELD");
            }else{
                JOptionPane.showMessageDialog(this, "YOU DONT HAVE ENOUGH MANA!! USE OTHER SKILLS OR PASS");
            }
            
            if(enemyData.getEnemyHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU KILLED ENEMY!! EARNED 300 C");
                cl.show(replaceablePanel, "Map");
                enemyData.setEnemyHealth(100);
                playerData.setCoin(300);
                
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                sidePanel.coinText.setText(Integer.toString(playerData.getCoin()));
            }
            
            if(playerData.getPlayerHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU DEAD... TRY AGAIN");
                dispose();
                System.exit(0);
            }
        });
        
        dungeonPanel.passButton.addActionListener(e -> {
            enemyData.setEnemyHealth(0);
            enemyData.setEnemyDamage();
            dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
            playerData.setPlayerHealth(-enemyData.getEnemyDamage());
            playerData.setPlayerMana(25);
            sidePanel.healthBar.setValue(playerData.getPlayerHealth());
            sidePanel.manaBar.setValue(playerData.getPlayerMana());
            JOptionPane.showMessageDialog(this, "YOU HIT 0 DAMAGE BUT YOU REGAIN 25 MANA!! ENEMY HIT "+ enemyData.getEnemyDamage() + " DAMAGE");
            
            if(enemyData.getEnemyHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU KILLED ENEMY!! EARNED 300 C");
                cl.show(replaceablePanel, "Map");
                enemyData.setEnemyHealth(100);
                playerData.setCoin(300);
                
                dungeonPanel.enemyHealthBar.setValue(enemyData.getEnemyHealth());
                sidePanel.coinText.setText(Integer.toString(playerData.getCoin()));
            }
            
            if(playerData.getPlayerHealth() <= 0){
                JOptionPane.showMessageDialog(this, "YOU DEAD... TRY AGAIN");
                dispose();
                System.exit(0);
            }
        });


        // --- Main Panel ---
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(replaceablePanel, BorderLayout.CENTER);
        mainPanel.add(sidePanel, BorderLayout.EAST);

        // --- Frame settings ---
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RPG Game");
        setIconImage(icon);
        setResizable(false);
        add(mainPanel);
        setVisible(true);
    }
}
