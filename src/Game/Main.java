package Game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main extends JFrame{
    public static boolean isAlive = true;
    
    public static void main(String[] args)
    {
        //Initialize PlayerData
        PlayerData playerData = new PlayerData();
        //
        JFrame frameMain = new JFrame();
        // Initialize DB before GUI
        Database.init();

        // Start GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            LoginScreen login = new LoginScreen();
            login.setVisible(true);

            // Use a background thread to wait until login window is closed
            new Thread(() -> {
                while (login.isDisplayable()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {}
                }

                if (login.isLoginSuccessful()) {
                    System.out.println("Login confirmed — starting game...");
                    // Açılacak oyun penceresi burada çağrılır
                    SwingUtilities.invokeLater(() -> new Frame().setVisible(true));
                } else {
                    System.out.println("Login failed or canceled. Exiting...");
                    System.exit(0);
                }
            }).start();
        });

        //Checkers
        while(isAlive){
            if(playerData.getPlayerHealth() <= 0){
                isAlive = false;
                JOptionPane.showMessageDialog(frameMain,"YOU DEAD... TRY AGAIN");
                frameMain.dispose();
                System.exit(0);
            }
            
            if(playerData.getPlayerHappiness() <= 0){
                isAlive = false;
                JOptionPane.showMessageDialog(frameMain, "YOU DEAD... TRY AGAIN");
                frameMain.dispose();
                System.exit(0);
            }
        }
    }
    
}
