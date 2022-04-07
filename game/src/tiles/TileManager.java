package tiles;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp)
    {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenHeight][gp.maxSreenLength];

        getTileImage();
        loadMap("/maps/map.txt");
    }

    public void getTileImage(){
        try{

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/GrassPlaceHolder.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/BrickPlaceHolder.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/WaterPlaceHolder.png")));



        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String filePass)
    {
        try{
            InputStream is = getClass().getResourceAsStream(filePass);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenHeight && row < gp.maxSreenLength){

                String line = br.readLine();

                while (col < gp.maxScreenHeight){

                    String nums[] = line.split(" ");

                    int num = Integer.parseInt(nums[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenHeight){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch(Exception e){
            System.out.println("Map Not Loading");
        }
    }

    public void draw(Graphics2D g2)
    {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenHeight && row < gp.maxSreenLength){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tilesize, gp.tilesize, null);
            col++;
            x += gp.tilesize;

            if(col == gp.maxScreenHeight)
            {
                col = 0;
                x = 0;
                row++;
                y += gp.tilesize;
            }
        }






        /*g2.drawImage(tile[1].image, 0, 0, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[1].image, 48, 0, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[1].image, 96, 0, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[1].image, 144, 0, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[1].image, 192, 0, gp.tilesize, gp.tilesize, null);

        g2.drawImage(tile[1].image, 0, 48, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 48, 48, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 96, 48, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 144, 48, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[1].image, 192, 48, gp.tilesize, gp.tilesize, null);

        g2.drawImage(tile[1].image, 0, 96, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 48, 96, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 96, 96, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 144, 96, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 192, 96, gp.tilesize, gp.tilesize, null);

        g2.drawImage(tile[1].image, 0, 144, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 48, 144, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 96, 144, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[0].image, 144, 144, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[1].image, 192, 144, gp.tilesize, gp.tilesize, null);

        g2.drawImage(tile[1].image, 0, 192, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[2].image, 48, 192, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[2].image, 96, 192, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[2].image, 144, 192, gp.tilesize, gp.tilesize, null);
        g2.drawImage(tile[1].image, 192, 192, gp.tilesize, gp.tilesize, null);*/
    }
}
