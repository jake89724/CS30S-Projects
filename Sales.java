/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import javax.swing.JOptionPane;

/**
 *
 * @author lazyf
 */
public class Sales {
    
    //global variables
    static int winnipeg[] = new int[10];
    static int calgary[] = new int[10];
    
    /**
     * main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "welcome to Rinky Dooflingy Company",
                "Intro",
                JOptionPane.INFORMATION_MESSAGE);
        direction();
    }

    /**
     * determines what the user wants to do
     */
    public static void direction() {
        final int SEE_WIN_SALES = 1;
        final int SEE_CAL_SALES = 2;
        final int ENTER_WIN_SALES = 3;
        final int ENTER_CAL_SALES = 4;
        final int SEE_TOTAL_SALES = 5;
        //ask user input 
        while (true) {
            String checkUserInput = JOptionPane.showInputDialog(null,
                    "\n(1) See Winnipeg Sales"
                    + "\n(2) See Calgary Sales"
                    + "\n(3) Enter Winnipeg Sales"
                    + "\n(4) Enter Calgary Sales"
                    + "\n(5) See Total Sales"
                    + "\n(6) Quit", "Enter Number",
                    JOptionPane.QUESTION_MESSAGE);
            int userInput = Integer.parseInt(checkUserInput);
            if (userInput == SEE_WIN_SALES) {
                outputWinnipeg();
            } else if (userInput == SEE_CAL_SALES) {
                outputCalgary();
            } else if (userInput == ENTER_WIN_SALES) {
                enterWinnipegSales();
            } else if (userInput == ENTER_CAL_SALES) {
                enterCalgarySales();
            } else if (userInput == SEE_TOTAL_SALES) {
                totalSales();
            } else {
                System.exit(0);
            }
        }
    }
    

    /**
     * for entering Winnipeg sales
     */
    public static void enterWinnipegSales() {
        boolean valid = false;
        try {
            for (int i = 0; i < 10; i++) {
                int numberPlace = i + 1;
                String checkUserInput = JOptionPane.showInputDialog(null,
                        "Enter Size #" + numberPlace, "Enter Winnipeg Sales",
                        JOptionPane.QUESTION_MESSAGE);
                int userInput = Integer.parseInt(checkUserInput);
                valid = true;
                winnipeg[i] = userInput;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Number not valid. Try again",
                    "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * for displaying Winnipeg sales
     */
    public static void outputWinnipeg() {
            String output = "";
            for (int i = 0; i < 10; i++) {
                int size = i + 1;
                output = output + "\nSize " + size + ": " + winnipeg[i];
                System.out.println(output);
            }
            JOptionPane.showMessageDialog(null, output, "Winnipeg Sales",
                    JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * for entering Calgary sales
     */
    public static void enterCalgarySales() {
        try {
            for (int i = 0; i < 10; i++) {
                int numberPlace = i + 1;
                String checkUserInput = JOptionPane.showInputDialog(null,
                        "Enter Size #" + numberPlace, "Enter Calgary Sales",
                        JOptionPane.QUESTION_MESSAGE);
                int userInput = Integer.parseInt(checkUserInput);
                calgary[i] = userInput;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Number. Try Again ",
                    "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * outputs the sales from Calgary
     */
    public static void outputCalgary() {
            String output = "";
            for (int i = 0; i < 10; i++) {
                int size = i + 1;
                output = output + "\nSize " + size + ": " + calgary[i];
                System.out.println(output);
            }
            JOptionPane.showMessageDialog(null, output, "Calgary Sales",
                    JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * displays total sales
     */
    public static void totalSales() {
        int total = 0;
        String output = "";
        for (int i = 0; i < 10; i++) {
            total = calgary[i] + winnipeg[i];
            int size = i + 1;
            output = output + "\nSize " + size + ": " + total;
        }
        JOptionPane.showMessageDialog(null, output, "Total Sales",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
