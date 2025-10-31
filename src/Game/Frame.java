package Game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Frame extends JFrame{
    
        Image icon = new ImageIcon(getClass().getResource("/Game/Resources/Icon.png")).getImage();
        Image map = new ImageIcon(getClass().getResource("/Game/Resources/Map.jpg")).getImage();
        Image button = new ImageIcon(getClass().getResource("/Game/Resources/Button.png")).getImage();
        Image panel = new ImageIcon(getClass().getResource("/Game/Resources/Panel.png")).getImage();
        Image guildHeadquarters = new ImageIcon(getClass().getResource("/Game/Resources/GuildHeadquarters.png")).getImage();
        Image blacksmith = new ImageIcon(getClass().getResource("/Game/Resources/Blacksmith.png")).getImage();
        Image portal = new ImageIcon(getClass().getResource("/Game/Resources/Portal.png")).getImage();
        Image tavern = new ImageIcon(getClass().getResource("/Game/Resources/Tavern.png")).getImage();
        Image barBorder = new ImageIcon(getClass().getResource("/Game/Resources/BarBorder.png")).getImage();
        Image healthBarFill = new ImageIcon(getClass().getResource("/Game/Resources/HealthBarFill.png")).getImage();
        Image staminaBarFill = new ImageIcon(getClass().getResource("/Game/Resources/StaminaBarFill.png")).getImage();
        
    Frame(){
        
        // --- Setup Panels ---
        Map mapPanel = new Map(map, button);
        SidePanel sidePanel = new SidePanel(panel, barBorder, healthBarFill, staminaBarFill);
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
        
        /*
        //MAIN PANEL
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        //REPLACEABLE PANEL
        JPanel replaceablePanel = new JPanel(new CardLayout());
        replaceablePanel.setBounds(0, 0, 960, 720);
        
        
        //MAP PANEL
        JPanel mapPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(map, 0, 0, 960, 685, this);  
            }
        };
        mapPanel.setBounds(0, 0, 960, 720);
        mapPanel.setOpaque(false);
        mapPanel.setLayout(null);
        
        //-Guild Headquarters Button
        JButton guildHeadquartersButton = new JButton();
        guildHeadquartersButton.setBounds(700, 300, 200, 50);
        ImageIcon rsGuildHeadquarters = new ImageIcon(button.getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        guildHeadquartersButton.setIcon(rsGuildHeadquarters);
        guildHeadquartersButton.setText("GUILD HEADQUARTERS");
        guildHeadquartersButton.setForeground(Color.white);
        guildHeadquartersButton.setHorizontalTextPosition(SwingConstants.CENTER);
        guildHeadquartersButton.setContentAreaFilled(false);
        guildHeadquartersButton.setBorderPainted(true);

        //-Blacksmith Button
        JButton blacksmithButton = new JButton();
        blacksmithButton.setBounds(175, 100, 200, 50);
        ImageIcon rsBlacksmith = new ImageIcon(button.getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        blacksmithButton.setIcon(rsBlacksmith);
        blacksmithButton.setText("BLACKSMITH");
        blacksmithButton.setForeground(Color.white);
        blacksmithButton.setHorizontalTextPosition(SwingConstants.CENTER);
        blacksmithButton.setContentAreaFilled(false);
        blacksmithButton.setBorderPainted(true);

        //-Tavern Button
        JButton tavernButton = new JButton();
        tavernButton.setBounds(400, 125, 200, 50);
        ImageIcon rsTavern = new ImageIcon(button.getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        tavernButton.setIcon(rsTavern);
        tavernButton.setText("TAVERN");
        tavernButton.setForeground(Color.white);
        tavernButton.setHorizontalTextPosition(SwingConstants.CENTER);
        tavernButton.setContentAreaFilled(false);
        tavernButton.setBorderPainted(true);
        
        //-Portal Button
        JButton portalButton = new JButton();
        portalButton.setBounds(750, 600, 200, 50);
        ImageIcon rsPortal = new ImageIcon(button.getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        portalButton.setIcon(rsPortal);
        portalButton.setText("GO TO PORTAL =>");
        portalButton.setForeground(Color.white);
        portalButton.setHorizontalTextPosition(SwingConstants.CENTER);
        portalButton.setContentAreaFilled(false);
        portalButton.setBorderPainted(true);
        
        //-Add Comp To Map Panel
        mapPanel.add(guildHeadquartersButton);
        mapPanel.add(blacksmithButton);
        mapPanel.add(tavernButton);
        mapPanel.add(portalButton);
        
        //SIDE PANEL
        JPanel sidePanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(panel, 960, 0, 310, 685, this);
            }
        };
        sidePanel.setBounds(960, 0, 320, 720);
        sidePanel.setOpaque(false);
        sidePanel.setLayout(null);
        
        //-Health Bar
        CustomBar healthBar = new CustomBar(healthBarFill, barBorder);
        healthBar.setBounds(1015, 75, 200, 50); 
        
        //-Stamina Bar
        CustomBar staminaBar = new CustomBar(staminaBarFill, barBorder);
        staminaBar.setBounds(1015, 150, 200, 50);
        
        //-Add Comp To Side Panel
        sidePanel.add(healthBar);
        sidePanel.add(staminaBar);
        
        //GUILD HEADQUARTERS
        JPanel guildHeadquartersPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(guildHeadquarters, 0, 0, 960, 685, this);
            }
        };
        guildHeadquartersPanel.setBounds(0, 0, 960, 720);
        guildHeadquartersPanel.setOpaque(false);
        guildHeadquartersPanel.setLayout(null);

        JPanel guildHeadquartersDownPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(panel, 0, 0, 960, 100, this);
            }
        };
        guildHeadquartersDownPanel.setBounds(0, 575, 960, 100);
        guildHeadquartersDownPanel.setOpaque(false);
        guildHeadquartersDownPanel.setLayout(null);
        
        //Go Back Button
        JButton ghBackButton = new JButton();
        ghBackButton.setBounds(625, 25, 200, 50);
        ImageIcon rsGHBackButton = new ImageIcon(button.getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        ghBackButton.setIcon(rsGHBackButton);
        ghBackButton.setText("GO TO CITY =>");
        ghBackButton.setForeground(Color.white);
        ghBackButton.setHorizontalTextPosition(SwingConstants.CENTER);
        ghBackButton.setContentAreaFilled(false);
        ghBackButton.setBorderPainted(true);
        
        JButton ghGetLicenceButton = new JButton();
        ghGetLicenceButton.setBounds(150, 25, 200, 50);
        ImageIcon rsGHGetLicenceButton = new ImageIcon(button.getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        ghGetLicenceButton.setIcon(rsGHGetLicenceButton);
        ghGetLicenceButton.setText("GET LICENCE");
        ghGetLicenceButton.setForeground(Color.white);
        ghGetLicenceButton.setHorizontalTextPosition(SwingConstants.CENTER);
        ghGetLicenceButton.setContentAreaFilled(false);
        ghGetLicenceButton.setBorderPainted(true);
        
        guildHeadquartersDownPanel.add(ghGetLicenceButton);
        guildHeadquartersDownPanel.add(ghBackButton);
        guildHeadquartersPanel.add(guildHeadquartersDownPanel);
        
        //INITIALIZE CARDLAYOUTS
        replaceablePanel.add(mapPanel, "Map");
        replaceablePanel.add(guildHeadquartersPanel, "Guild Headquarters");
        
        CardLayout cl = (CardLayout) replaceablePanel.getLayout();
        cl.show(replaceablePanel, "Map");
        
        //Add Panels To Main Panel
        mainPanel.add(replaceablePanel, BorderLayout.CENTER);
        mainPanel.add(sidePanel);
        
        //BUTTON FUNCTIONS
        
        //-Map
        guildHeadquartersButton.addActionListener(e -> cl.show(replaceablePanel, "Guild Headquarters"));
        
        //-Guild Headquarters
        ghBackButton.addActionListener(e -> cl.show(replaceablePanel, "Map"));
        
        //INITIALIZE START
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RPG Game");
        this.setIconImage(icon);
        this.setResizable(false);
        this.add(mainPanel);
        this.setVisible(true);*/
    }
}
