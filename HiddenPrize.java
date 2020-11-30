/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiddenprize;

import javax.swing.JOptionPane;

/**
 *
 * @author lazyf
 */
public class HiddenPrize {

    static int[][] board = new int[4][5];
    static final int COMP = 1;
    static final int UTER = 2;
    static final int NULL = 0;
    static int tracker = 0;
    static int tries = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        drawArray();
        output();
    }

    private static void drawArray() {
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

    private static void outputArray(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void output() {
        int[][] output = new int[4][5];
        equateToZero(output);
        int counter = 10;
        while (true) {
            String row1 = "";
            String row2 = "";
            String row3 = "";
            String row4 = "";
            for (int i = 0; i < output[0].length; i++) {
                row1 = row1 + "  " + output[0][i] + "  |";
                row2 = row2 + "  " + output[1][i] + "  |";
                row3 = row3 + "  " + output[2][i] + "  |";
                row4 = row4 + "  " + output[3][i] + "  |";
            }
            String checkUserInput = JOptionPane.showInputDialog(
                    "      C1 | C2 | C3 | C4 | C5"
                    + "\nR1|" + row1
                    + "\nR2|" + row2 + "      1 = COMP"
                    + "\nR3|" + row3 + "      2 = Uter"
                    + "\nR4|" + row4 + "      5 = Nothing" + "\n "
                            + "\nYou Have | " + counter + " | Guesses Left\n"
                    + "-----------------------------------------------------"
                    + "\n| Enter:                               |"
                    + "\n|  -1 to make a guess     |"
                    + "\n|  -2 to start new game  |"
                    + "\n|  -3 to quit                         |\n\n");
            int userInput = Integer.parseInt(checkUserInput);
            if (userInput == 1) {
                output = guess(output);
                counter--;
            } else if (userInput == 2) {
                equateToZero(output);
                drawArray();
                tracker = 0;
                counter = 10;
            } else {
                System.exit(0);
            }
            if (tracker == 2){
                equateToZero(output);
                drawArray();
                tracker = 0;
                JOptionPane.showMessageDialog(null, "Congrats you won after "
                        + tries + "Attempts!");
                tries = 0;
                counter = 10;
            }
            if (counter <= 0) {
                JOptionPane.showMessageDialog(null, "Sorry Out Of guesses");
                equateToZero(output);
                drawArray();
                tracker = 0;
                counter = 10;
            }
        }
    }

    public static void equateToZero(int[][] output) {
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                output[i][j] = 0;
            }
        }
    }


    public static int[][] guess(int[][] output) {
        String row = JOptionPane.showInputDialog("Enter Row (1-4)");
        String col = JOptionPane.showInputDialog("Enter Col (1-5)");
        int mainRow = Integer.parseInt(row) - 1;
        int mainCol = Integer.parseInt(col) - 1;
        if (board[mainRow][mainCol] == NULL) {
            System.out.println("Nothing");
            output[mainRow][mainCol] = 5;
        } else if (board[mainRow][mainCol] == COMP) {
            tracker++;
            System.out.println("1 or COMP");
            output[mainRow][mainCol] = COMP;
        } else if (board[mainRow][mainCol] == UTER) {
            tracker++;
            System.out.println("2 or Uter");
            output[mainRow][mainCol] = UTER;
        }
        
        tries++;
        return output;
    }

}
