package odd.even.game;

import javax.swing.JOptionPane;

/**
 * OddEvenGame.java - description
 *
 * @author Jacob Head
 * @since Nov. 3, 2020
 */
public class OddEvenGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

    public static void bet(int money) {
        boolean valid = false;
        int max = money;
        int low = 1;
        int betMoney = 0;
        boolean stop = false;
        while (stop == false){
          while (valid == false){
            try{
                System.out.println("Wwe made it");
                String checkBet = JOptionPane.showInputDialog("You have $"
                    + money
                    + "\n Place Bet");
            if(checkBet == null) endGame();
            betMoney = Integer.parseInt(checkBet);
            if(betMoney >= low && betMoney <= max){
                valid = true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
            } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please Enter A Valid Bet");
            }
        }
          
        money = game(betMoney);
            System.out.println("play again confirmed");
        }   
    }

     private static int random() {
        final int high = 6;
        final int low = 1;
        double seed = Math.random();
        double number = (high - low + 1) * seed + low;
        int randomNumber = (int) number;
        System.out.println(randomNumber);
        return(randomNumber);
    }
     
    private static int game(int betMoney) {
        int afterBetResult = betMoney;
        int sum = random() + random();
        boolean even = false;
        boolean odd = false;
        int totalBet = 0;
        //checks if even
        if (sum == 2 || sum == 4 || sum == 6
                || sum == 8 || sum == 10
                || sum == 12) even = true;
        
        if (even == true) {
            totalBet = 0;
            JOptionPane.showMessageDialog(null, "The Result Was Even "
            + "(" + sum + ")" + "\n You Lost....."
                    + " you lost the money you bet..", "LOSER",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else {
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
        if (playAgain != 0)endGame();       
        
        return(totalBet);
        
    }

    private static void endGame() {
        System.exit(0);
    }

}
