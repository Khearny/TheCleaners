package Game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main{

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
                        new Frame();
                    });
                } else {
                    System.out.println("Login failed or canceled. Exiting...");
                    System.exit(0);
                }
            }).start();
        });
    }
}

