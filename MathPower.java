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
        int level = 1;
        direction(1);
    }
    
    public static void direction(int level){
        boolean stop = false;
        int addPoints = 0;
        while (stop == false){
           String userInput = JOptionPane.showInputDialog("(Level " + level + ")"
        + "\n Addition = 1 " + addPoints + "/100" 
        + "\n Subtraction = 2"
        + "\n multiplication = 3"
        + "\n Division = 4");
        int direction = Integer.parseInt(userInput);
        if (direction == 1){
            addPoints = addition(level);
        } 
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

    public static int addition(int level) {
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
                    if (counter == 1) {
                        points = points + 10;
                    } else if (counter == 2) {
                        points = points + 5;
                    } else {
                        points = points + 2;
                    }
                    System.out.println("points = " + points);

                    JOptionPane.showMessageDialog(null,
                            "Congrats You Got it On Your "
                            + counter
                            + " Try!"
                            + "\n points = " + points + "/100");
                    stop = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong, Try Again");
                    System.out.println("Wrong: Try Again");

                    if (counter >= 3) {
                        JOptionPane.showMessageDialog(null, "U Failed Loser (points = " + points + ")");
                        stop = true;
                    }

                }

            }
            System.out.println("points = " + points);

        }
        if (points >= 100) {
            System.out.println("U going to next level nice");
            level++;
        }
        return (points);
        // ///////////////////////////////
    }

}
