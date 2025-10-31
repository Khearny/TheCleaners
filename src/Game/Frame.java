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
        
    Frame(){
        
        // --- Setup Panels ---
        Map mapPanel = new Map(map, button);
        SidePanel sidePanel = new SidePanel(panel, barBorder, healthBarFill, manaBarFill, licence, licenceTick);
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
            GuildHeadquarters.isGetLicence = true;
            sidePanel.licenceTick.setVisible(true);
            System.out.println("You get a licence");
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
