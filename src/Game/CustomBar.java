package Game;

import javax.swing.*;
import java.awt.*;

public class CustomBar extends JPanel{
    
    private int value = 100;
    private Image fillImage;
    private Image borderImage;
    private int currentValue = 100; 
    private int targetValue = 100; 
    private Timer timer;

    public CustomBar(Image fillImage, Image borderImage) {
        this.fillImage = fillImage;
        this.borderImage = borderImage;
        setOpaque(false);
        
        timer = new Timer(15, e -> {
            if (currentValue < targetValue) currentValue++;
            else if (currentValue > targetValue) currentValue--;
            repaint();
        });
        timer.start();
    }

    public void setValue(int newValue) {
        this.value = Math.max(0, Math.min(100, newValue));
        repaint();
    }

    public int getValue() {
        return value;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        int fillMargin = 4;
        int borderOffset = -2;


        int fillWidth = (int) ((width - fillMargin * 2) * (currentValue / 100.0));
        int fillHeight = height - fillMargin * 2;


        g2.drawImage(fillImage, fillMargin, fillMargin, fillWidth, fillHeight, this);


        g2.drawImage(borderImage, borderOffset, borderOffset, width - borderOffset * 2, height - borderOffset * 2, this);
        
        String text = currentValue + "%";
        g2.setColor(Color.white);
        g2.setFont(new Font("Arial", Font.BOLD, 16)); 
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();

        int textX = (width - textWidth) / 2;
        int textY = (height + textHeight) / 2 - 2;
        g2.drawString(text, textX, textY);
    }
}
