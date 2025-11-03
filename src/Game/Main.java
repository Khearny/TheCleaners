package Game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame{
    public static boolean isAlive = true;
    
    public static void main(String[] args)
    {
        Frame frame = new Frame();
        PlayerData playerData= new PlayerData();
        
        while(isAlive){
            if(playerData.getPlayerHealth() <= 0){
                isAlive = false;
                JOptionPane.showMessageDialog(frame, "YOU DEAD... TRY AGAIN");
                frame.dispose();
                System.exit(0);
            }
            
            if(playerData.getPlayerHappiness() <= 0){
                isAlive = false;
                JOptionPane.showMessageDialog(frame, "YOU DEAD... TRY AGAIN");
                frame.dispose();
                System.exit(0);
            }
        }
    }
    
}
