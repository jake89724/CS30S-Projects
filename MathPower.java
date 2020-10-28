package mathpower;

import javax.swing.JOptionPane;

/**
 * MathPower.java - description
 *
 * @author Jacob Head
 * @since Oct. 26, 2020
 */
public class MathPower {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userInput = JOptionPane.showInputDialog("What do you want to do?");
        if (userInput.equals("a")) {
            addition(1);
        }
    }

    // returns random number
    public static int random(int low, int high) {
        double seed = Math.random();
        double number = (high - low + 1) * seed + low;
        int randomNumber = (int) number;
        System.out.println(randomNumber);
        return (randomNumber);
    }

    public static void addition(int level) {
        // this is for addition questions

        int low = 0;
        int high = 0;
        int points = 0;
        // if level , is for geting the number values based on lavel 
        if (level == 1) {
            high = 100;
            low = 1;
        }

        // this is for 10 seperate questions
        for (int i = 0; i < 10; i++) {
            /**
             * stop is for the loop to keep going until specific question is
             * passed or failed
            *
             */
            boolean stop = false;
            // to calulate points
            int counter = 0;

            // getting the two values for level 1
            int number1 = random(low, high);
            int number2 = random(low, high);
            //keeps looping until question is correct o rmax time reached
            while (stop == false) {

                String userInput = JOptionPane.showInputDialog(
                        "What Is "
                        + number1
                        + " + "
                        + number2);

                // calculates the answer
                int sum = number1 + number2;
                // converts userInput to int 
                int userAnswer = Integer.parseInt(userInput);
                counter++;
                //checks answer
                if (userAnswer == sum) {
                    JOptionPane.showMessageDialog(null,
                            "Congrats You Got it On Your "
                            + counter
                            + " Try!");
                    stop = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong, Try Again");
                    System.out.println("Wrong: Try Again");
                }
                if (counter > 3) {
                    JOptionPane.showMessageDialog(null, "U Failed Loser");
                    stop = true;
                }

            }

            // for points
            if (counter == 1) {
                points = points + 10;
            } else if (counter == 2) {
                points = points + 5;
            } else {
                points = points + 2;
            }
            System.out.println("points = " + points);

        }

    }

}
