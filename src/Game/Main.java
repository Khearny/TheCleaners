package Game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main extends JFrame{

    public static void main(String[] args) {
        PlayerData playerData = new PlayerData();

        SwingUtilities.invokeLater(() -> {
            Database.init();
            LoginScreen login = new LoginScreen();
            login.setVisible(true);

            new Thread(() -> {
                while (login.isDisplayable()) {
                    try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                }

                if (login.isLoginSuccessful()) {
                    System.out.println("Login confirmed — starting game...");
                    SwingUtilities.invokeLater(() -> {
                        Frame gameFrame = new Frame();
                        gameFrame.setVisible(true);

                        new javax.swing.Timer(500, e -> {
                            if (playerData.getPlayerHealth() <= 0 ||
                                playerData.getPlayerHappiness() <= 0) {
                                JOptionPane.showMessageDialog(null, "YOU DEAD... TRY AGAIN");
                                System.exit(0);
                            }
                        }).start();
                    });
                } else {
                    System.out.println("Login failed or canceled. Exiting...");
                    System.exit(0);
                }
            }).start();
        });
    }
}

