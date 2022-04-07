package entity;

import game.GamePanel;
import game.keyInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class player extends entity{

    static GamePanel gp;
    static keyInput key;

    public player(GamePanel gp, keyInput key){
        this.gp = gp;
        this.key = key;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y =100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player.jpg")));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void update(){
        if (key.upPressed || key.downPressed || key.leftPressed || key.rightPressed){
            if (key.upPressed)
            {
                direction = "up";
                y -= speed;
            } else if (key.downPressed){
                direction = "down";
                y += speed;
            } else if (key.leftPressed){
                direction = "left";
                x -= speed;
            } else if (key.rightPressed){
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter > 12)
            {
                if (spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }




    }
    public static void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tilesize, gp.tilesize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum == 1)
                    image = up1;
                if (spriteNum == 2)
                    image = up2;
                break;
            case "down":
                if (spriteNum == 1)
                    image = down1;
                if (spriteNum == 2)
                    image = down2;
                break;
            case "left":
                if (spriteNum == 1)
                    image = left1;
                if (spriteNum == 2)
                    image = left2;
                break;
            case "right":
                if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                break;
        }
        g2.drawImage(image, x, y, gp.tilesize, gp.tilesize, null);
    }
}
