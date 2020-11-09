
package oddevengame;

import javax.swing.JOptionPane;

public class OddEvenGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // shows rules
        JOptionPane.showMessageDialog(null, "Rules! "
                + "\n -You have $1000 to start"
                + "\n -You can place a bet less than the money you have"
                + "\n -Once bet is placed two dice will be rolled"
                + "\n -If sum of two dice is even you lose the money you bet"
                + "\n -If sum = even you double the money you bet",
                "Start",
                JOptionPane.INFORMATION_MESSAGE);
        bet(1000);
    }

    /**
     * makes bet + game loop
     * @param money the total money you have
     */
    public static void bet(int money) {
        int betMoney = 0;
        int totalMoney = 0;
        int resultMoney = 0;
        boolean stop = false;
        // stop = main game loop
        while (stop == false) {

            boolean valid = false;
            //valid for determining if user input is valid
            while (valid == false) {
                if (money == 0) {
                    JOptionPane.showMessageDialog(null, "Out Of Money :(",
                            "No Money Left",
                            JOptionPane.INFORMATION_MESSAGE);
                    endGame();
                }

                try {
                    //asks for bet
                    String checkBet = JOptionPane.showInputDialog(null, 
                            "You have $"
                            + money
                            + "\n Place Bet", "Enter Bet", 
                            JOptionPane.QUESTION_MESSAGE
                            );
                    if (checkBet == null) endGame();
                    //converts to int
                    betMoney = Integer.parseInt(checkBet);
                    //figures out if bet is valid 
                    int max = money;
                    int low = 1;
                    if (betMoney >= low && betMoney <= max) {
                        valid = true;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid number",
                                "Number Not Valid",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Please Enter A Valid Bet",
                            "No Letters", JOptionPane.INFORMATION_MESSAGE
                            );
                }
            }

            resultMoney = game(betMoney);
            //calculates total money
            if (resultMoney > betMoney) {
                money = money + resultMoney;
            } else {
                money = money - betMoney;
            }
            System.out.println("play again confirmed");
        }
    }

    /**
     * generates random number
     * @return returns int 1 - 6
     */
    private static int random() {
        final int high = 6;
        final int low = 1;
        double seed = Math.random();
        double number = (high - low + 1) * seed + low;
        int randomNumber = (int) number;
        System.out.println(randomNumber);
        return (randomNumber);
    }

    /**
     * determines if odd or even and calculates prize
     * @param betMoney the amount the user bets
     * @return the result of prize money
     */
    private static int game(int betMoney) {
        int sum = random() + random();
        boolean even = false;
        int totalBet = 0;
        //checks if even
        if (sum == 2 || sum == 4 || sum == 6
                || sum == 8 || sum == 10
                || sum == 12) {
            even = true;
        }
        // outputs result and calculates prize money
        if (even == true) {
            totalBet = 0;
            JOptionPane.showMessageDialog(null, "The Result Was Even "
                    + "(" + sum + ")" + "\n You Lost....."
                    + " you lost the money you bet..", "LOSER",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            totalBet = betMoney * 2;
            JOptionPane.showMessageDialog(null, "The Result Was Odd! "
                    + "(" + sum + ")" + "\n You Won " + betMoney + "(2) "
                    + "= $" + totalBet, "WINNER",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        int playAgain = JOptionPane.showConfirmDialog(null,
                "Wanna Play Again?",
                "Play Again?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        System.out.println(playAgain);
        // if user does not want to play again close program
        if (playAgain != 0) {
            endGame();
        }

        return (totalBet);

    }

    /**
     * probably the longest method ever written (closes program)
     */
    private static void endGame() {
        System.exit(0);
    }

}
