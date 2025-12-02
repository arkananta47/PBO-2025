
/**
 * Write a description of class Paddle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;

public class Paddle {
    
    int x, y;
    int player;
    int yVelocity = 0;
    int speed = 5;
    int width = 20;
    int height = 100;
    
    public Paddle(int x, int y, int player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
    
    // Memperbarui posisi vertikal (y) berdasarkan kecepatan
    public void move() {
        y += yVelocity;
        if (y < 0) {
            y = 0;
        }
        if (y > GamePanel.GAME_HEIGHT - height) {
            y = GamePanel.GAME_HEIGHT - height;
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if (player == 1){
            switch(e.getKeyCode()) {
                case KeyEvent.VK_W:
                    yVelocity = -speed; 
                    break;
                case KeyEvent.VK_S: 
                    yVelocity = speed; 
                    break;
            }
        }
        
        if (player == 2){
            switch(e.getKeyCode()) {                
                case KeyEvent.VK_UP: 
                    yVelocity = -speed; 
                    break;
                case KeyEvent.VK_DOWN: 
                    yVelocity = speed; 
                    break;
            }
        }
    }
    
    // Menghentikan pergerakan (kecepatan = 0) ketika tombol dilepas
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                yVelocity = 0;
                break;
        }
    }
}