// Author Cameron Kerley(terpyPY)
// Created: 14/8/2022
package game;
public class neighbors{
    private int[] reArray = new int[8];
    // test array
    public static void main(String[] args) {
        // test array
        int[][] test = new int[10][10];
        
        neighbors n = new neighbors(test.length,2,2);
    }

    // search the grid by the cords given return the number of neighbors in 8 neighbor eval
    // returns an array of the (col,row) of the neighbors
    public neighbors(int lenMatrix, int rowNumber, int colNumber){
        // start at -1 to account for the 0 index and wrap around for -1 in row 
        for(int rowAdd = -1; rowAdd <= 1; rowAdd++){
            // increment the row pointer to the next row
            int newRow = rowNumber + rowAdd;
            // len matrix bounds the search to the length of the matrix -1 for ordinality
            if(newRow >= 0 && newRow <= lenMatrix-1){
                // start at -1 to account for the 0 index and wrap around for -1 in col
                for(int colAdd = -1; colAdd <= 1; colAdd++){
                    // increment the col pointer to the next col
                    int newCol = colNumber + colAdd;
                    // len matrix bounds the search to the length of the matrix -1 for ordinality
                    if(newCol >= 0 && newCol <= lenMatrix-1){
                        // if the new row and new col are not the same as the original row and col
                        // if so skip this value
                        if(newCol == colNumber && newRow == rowNumber){
                            continue;
                        }

                        else{
                            System.out.println("(" + newCol + "," + newRow + ")");
                            
                            }
                           
                        }
                    }
                
                }
                
            }
        }
    public int[] returnNeighbors(){
        return reArray;
    }
}
