
/**
 * Write a description of class GamePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 600;

    Thread gameThread;
    Image image;
    Graphics graphics;
    
    Paddle player1, player2;
    Ball ball;

    int score1 = 0;
    int score2 = 0;

    public GamePanel() {
        player1 = new Paddle(0, (GAME_HEIGHT / 2) - 50, 1); 
        player2 = new Paddle(GAME_WIDTH - 20, (GAME_HEIGHT / 2) - 50, 2); 
        ball = new Ball((GAME_WIDTH / 2) - 15, (GAME_HEIGHT / 2) - 15);
        
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(new AL()); 
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    
    public void draw(Graphics g) {
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 40));
        g.drawString(String.valueOf(score1), (GAME_WIDTH / 2) - 50, 50);
        g.drawString(String.valueOf(score2), (GAME_WIDTH / 2) + 25, 50);
    }
    
    public void move() {
        player1.move();
        player2.move();
        ball.move();
        checkCollision();
    }

    public void run() {
        double nsPerFrame = 1000000000 / 60.0;
        long lastTime = System.nanoTime();
        double delta = 0;
        
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;
            
            while (delta >= 1) {
                move();
                repaint();
                delta--;
            }
        }
    }
    
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }

    public void resetBall() {
        ball.x = (GAME_WIDTH / 2) - (ball.diameter / 2);
        ball.y = (GAME_HEIGHT / 2) - (ball.diameter / 2);

        // Arah acak setelah reset
        ball.xVelocity = ball.xVelocity > 0 ? -3 : 3;
        ball.yVelocity = ball.yVelocity > 0 ? -3 : 3;
    }
    
    public void checkCollision() {
        if (ball.getBounds().intersects(player1.getBounds())) {
            ball.xVelocity = Math.abs(ball.xVelocity);
        }
        
        if (ball.getBounds().intersects(player2.getBounds())) {
            ball.xVelocity = -Math.abs(ball.xVelocity);
        }

        // player 2 mendapat poin (bola keluar kiri)
        if (ball.x <= 0) {
            score2++;
            resetBall();
        }

        // player 1 mendapat poin (bola keluar kanan)
        if (ball.x >= GAME_WIDTH - ball.diameter) {
            score1++;
            resetBall();
        }
    }
}
