package random.dice;

import javax.swing.JOptionPane;

public class RandomDice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "You got a dollar, wanna bet?");
        Check_Money(Random(), Random(), Random());
    }

    public static int Random() {
        //generates and returns number from 1 - 6
        double seed = Math.random();
        double number = (6 - 1 + 1) * seed + 1;
        int rollNumber = (int) number;
        System.out.println(rollNumber);
        return (rollNumber);
    }

    public static void Check_Money(int number1, int number2, int number3) {
        int money;
        if (number1 == 6 && number2 == 6 && number3 == 6) {
            money = 20;
        } else if (number1 == number2 && number2 == number3) {
            money = 10;
        } else if (number1 == number2 || number1 == number3 || number2 == number3
                || number2 == number1) {
            money = 5;
        } else {
            money = 0;
        }

        if (money == 20) {

            JOptionPane.showMessageDialog(null, ""
                    + "roll one = " + number1 + ""
                    + "\n roll two = " + number2 + ""
                    + "\n roll three = " + number3 + ""
                    + "\nYou Got All Sixes! Prize = $20");
        } else if (money == 10) {
            JOptionPane.showMessageDialog(null, ""
                    + "roll one = " + number1 + ""
                    + "\n roll two = " + number2 + ""
                    + "\n roll three = " + number3 + ""
                    + "\nYou Got Three Of The Same! Prize = $10");
        } else if (money == 5) {
            JOptionPane.showMessageDialog(null, " "
                    + "roll one = " + number1 + ""
                    + "\n roll two = " + number2 + ""
                    + "\n roll three = " + number3 + ""
                    + "\nYou Got two Of The Same! Prize = $5");
        } else if (money == 0) {
            JOptionPane.showMessageDialog(null, " "
                    + "roll one = " + number1 + ""
                    + "\n roll two = " + number2 + ""
                    + "\n roll three = " + number3 + ""
                    + "\nNone were the same. Prize = $0");
        }
        int again = JOptionPane.showConfirmDialog(null,
                "Want to go again?", " ", JOptionPane.YES_NO_OPTION);
        if (again == 0) {
            Check_Money(Random(), Random(), Random());
        } else if (again == 1) {
            System.exit(0);
        }

    }

}
