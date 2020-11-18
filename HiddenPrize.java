package hiddenprize;

/**
 * HiddenPrize.java - guessing game
 *
 * @author Jacob Head
 * @since Nov. 18, 2020
 */
public class HiddenPrize {

    static int[][] board = new int[4][5];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        drawArray();
        game();
    }

    private static void drawArray() {
        final int COMP = 1;
        final int UTER = 2;
        final int NULL = 0;
        int row = 0;
        int column = 0;
        int row1 = 0;
        int column1 = 0;
        //draw board
        
        //set all places to 0
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = NULL;
            }
        }
        
        // set coords
        column = random(0, 4);
        row = random(0, 3);
        board[row][column] = COMP;
        //makes sure you can't get same coords twice
        do {
            column1 = random(0, 4);
            row1 = random(0, 3);
        } while (column1 == column || row == row1);
        
        board[row1][column1] = UTER;
        ////////////////////////////////////
        
        //out coords
        outputArray(board);
    }

    private static int random(int low, int high) {
        double seed = Math.random();
        double number = (high - low + 1) * seed + low;
        int randomNumber = (int) number;
        return (randomNumber);
    }

    private static void outputArray(int [][] board) {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void game() {
        //while(true){
            // game loop here ADD STUFF PLZ
        //}
        System.out.println("Made it to game loop epic");
    }
    

}
