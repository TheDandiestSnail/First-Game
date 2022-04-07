package game;

import java.util.Scanner;
import java.util.Arrays;
public class map {
    Scanner scan = new Scanner(System.in);
    static String[][] map  = new String[9][9];
    String player;


    public static void main(String[] args){
        map[8][8] = "[Healing Center]";
        map[4][0] = "[House]";
        map[4][4] = "[Road]";
        //System.out.println(Arrays.deepToString(game.map));

        for (int k = 0; k < map.length; k++)
        {
            for (int t = 0; t < map[k].length; t++)
            {
                if (map[4][t] == null)
                {
                    map[4][t] = "[Road ]";
                }
                if (map[k][4] == null)
                {
                    map[k][4] = "[Road]";
                }
            }
        }


        for (int i = 0; i < map.length; i++)
        {
            for (int o = 0; o < map[i].length; o++)
                if (map[i][o] == null)
                {
                    map[i][o] = "[Grass]";
                }
        }



        for (int r = 0; r < map.length; r++) {       //for loop for row iteration.
            for (int c = 0; c < map[r].length; c++) {   //for loop for column iteration.
                System.out.print(map[r][c] + " ");
            }
            System.out.println(); //using this for new line to print array in matrix format.
        }
    }

}
