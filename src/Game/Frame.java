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
        
    Frame(){
        Random rand = new Random();
        PlayerData player = new PlayerData();
        
        // --- Setup Panels ---
        Map mapPanel = new Map(map, button);
        SidePanel sidePanel = new SidePanel(panel, barBorder, healthBarFill, manaBarFill, licence, licenceTick, coin, equipment, happiness, skills);
        GuildHeadquarters guildPanel = new GuildHeadquarters(guildHeadquarters, panel, button);
        Blacksmith blacksmithPanel = new Blacksmith(blacksmith, panel, button);
        Portal portalPanel = new Portal(portal, panel, button);
        Tavern tavernPanel = new Tavern(tavern, panel, button);

        JPanel replaceablePanel = new JPanel(new CardLayout());
        replaceablePanel.add(mapPanel, "Map");
        replaceablePanel.add(guildPanel, "Guild Headquarters");
        replaceablePanel.add(blacksmithPanel, "Blacksmith");
        replaceablePanel.add(portalPanel, "Portal");
        replaceablePanel.add(tavernPanel, "Tavern");

        CardLayout cl = (CardLayout) replaceablePanel.getLayout();
        cl.show(replaceablePanel, "Map");

        // --- Button actions ---
        mapPanel.guildHeadquartersButton.addActionListener(e -> cl.show(replaceablePanel, "Guild Headquarters"));
        mapPanel.blacksmithButton.addActionListener(e -> cl.show(replaceablePanel, "Blacksmith"));
        mapPanel.portalButton.addActionListener(e -> cl.show(replaceablePanel, "Portal"));
        mapPanel.tavernButton.addActionListener(e -> cl.show(replaceablePanel, "Tavern"));
        
        guildPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        blacksmithPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        portalPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        tavernPanel.backButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        
        guildPanel.getLicenceButton.addActionListener(e -> {
            if(player.getIsGetLicence() == false && player.getCoin() >= 200){
                player.setCoin(-200);
                sidePanel.coinText.setText(Integer.toString(PlayerData.playerCoin));
                player.setIsGetLicence(true);
                sidePanel.licenceTick.setVisible(true);
                guildPanel.getLicenceButton.setVisible(false);
                guildPanel.learnSkillsButton.setBounds(150, 25, guildPanel.learnSkillsButton.getWidth(), guildPanel.learnSkillsButton.getHeight());
            }else{
                JOptionPane.showMessageDialog(this, "YOU NEED COIN TO GET LICENCE");
            }
        });
        
        guildPanel.learnSkillsButton.addActionListener(e -> {
            if(player.getIsLearnSkill() == false && player.getCoin() >= 100){
                player.setCoin(-100);
                sidePanel.coinText.setText(Integer.toString(PlayerData.playerCoin));
                player.setIsLearnSkill(true);
                sidePanel.skillsTick.setVisible(true); 
                guildPanel.learnSkillsButton.setVisible(false);
                guildPanel.backButton.setBounds(390, 25, guildPanel.backButton.getWidth(), guildPanel.backButton.getHeight());
            }else{
                JOptionPane.showMessageDialog(this, "YOU NEED COIN TO LEARN SKILLS");
            }
        });
        
        blacksmithPanel.getEquipmetButton.addActionListener(e -> {
            if(player.getIsGetEquipment() == false && player.getCoin() >= 200){
                player.setCoin(-200);
                sidePanel.coinText.setText(Integer.toString(PlayerData.playerCoin));
                player.setIsGetEquipment(true);
                sidePanel.equipmentTick.setVisible(true);
                blacksmithPanel.getEquipmetButton.setVisible(false);
                blacksmithPanel.backButton.setBounds(390, 25, blacksmithPanel.backButton.getWidth(), blacksmithPanel.backButton.getHeight());
            }else{
                JOptionPane.showMessageDialog(this, "YOU NEED COIN TO GET EQUIPMENT");
            }
        });
        
        tavernPanel.drinkButton.addActionListener(e -> {
            if(player.getCoin() >= 25){
                player.setCoin(-25);
                sidePanel.coinText.setText(Integer.toString(PlayerData.playerCoin));
                player.setPlayerHealth(20);
                player.setPlayerMana(20);
                player.setPlayerHappiness(25);
                
                sidePanel.healthBar.setValue(PlayerData.playerHealth);
                sidePanel.manaBar.setValue(PlayerData.playerMana);
                sidePanel.happinessText.setText(Integer.toString(PlayerData.playerHappiness) + "%");
            }else{
                JOptionPane.showMessageDialog(this, "GET LOST!!!");
            }
        });
        
        tavernPanel.playGameButton.addActionListener(e -> {
            if(player.getCoin() >= 50){
                player.setCoin(-50);
                sidePanel.coinText.setText(Integer.toString(PlayerData.playerCoin));
                int randomNum = rand.nextInt(2);
                
                if(randomNum == 0){
                    JOptionPane.showMessageDialog(this, "Haha... You lost 50 C!");
                    player.setPlayerHappiness(5);
                    sidePanel.happinessText.setText(Integer.toString(PlayerData.playerHappiness) + "%");
                }
                
                if(randomNum == 1){
                    JOptionPane.showMessageDialog(this, "Ahh... You won 100 C!");
                    player.setCoin(100);
                    sidePanel.coinText.setText(Integer.toString(PlayerData.playerCoin));
                    player.setPlayerHappiness(-5);
                    sidePanel.happinessText.setText(Integer.toString(PlayerData.playerHappiness) + "%");
                }
            }else{
                JOptionPane.showMessageDialog(this, "NO MONEY, NO FUNNY");
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
