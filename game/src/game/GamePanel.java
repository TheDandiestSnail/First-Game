package game;

import entity.player;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Sreen settings
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tilesize = originalTileSize * scale;
    final int maxScreenHeight = 12;
    final int maxSreenLength = 16;
    final int screenWidth = maxSreenLength * tilesize;
    final int screenHeight = maxScreenHeight * tilesize;

    int FPS = 60;

    keyInput key = new keyInput();
    Thread gameThread;
    player pr = new player(this, key);


    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null)
        {
            long currentTime = System.nanoTime();

            //update
            update();

            //draw
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);

        g2.dispose();
    }
}
