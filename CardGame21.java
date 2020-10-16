

package cardgame21;

import javax.swing.JOptionPane;

/**
 * CardGame21.java - description
 * 
 * @author Jacob Head
 * @since Oct. 16, 2020
 */
public class CardGame21 {

    public static void main(String[] args) {
        //sets constants to "avoid magic numbers"
        final String HIT = "h";
        final String STAND = "s";
        //generates player cards
        int playerCard1 = drawCard();
        int playerCard2 = drawCard();
                
        //generates computer cards
        int computerCard1 = drawCard();
        int computerCard2 = drawCard();
        //creates input variables for loop
        String userInput = "";
        int counter = 2;
        int sumOfCards = playerCard1 + playerCard2;
        while (!userInput.equals(STAND)){
        int playerCard3 = 0;
        int playerCard4 = 0; // 
        int playerCard5 = 0;
            userInput = JOptionPane.showInputDialog(null, "Your cards are: "
                    + playerCard1
                    +", "
                    + playerCard2
                    + ", "
                    + playerCard3 
                    + ", "
                    + playerCard4 
                    + ", "
                    + playerCard5 + ": cards that equal " + sumOfCards );
            if (userInput.equals(HIT)){
                counter++;
                if (counter == 3){
                    playerCard3 = drawCard();
                }
                else if(counter == 4){
                    playerCard4 = drawCard();
                }
            }
        }
    }
    
    public static int drawCard(){
        final int HIGH = 10;
        final int LOW = 1;
        double seed = Math.random();
        double number = (HIGH - LOW + 1) * seed + LOW;
        int cardDraw = (int) number;
        return(cardDraw);
    }
}
