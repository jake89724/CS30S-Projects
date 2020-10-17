package cardgame21;

import javax.swing.JOptionPane;

public class CardGame21 {

    public static void main(String[] args) {
        //set constants to "avoid magic numbers"
        final String HIT = "h";
        final String STAND = "s";
        final int MAX_NUMBER = 21;
        //generates player cards
        int playerCard1 = drawCard();
        int playerCard2 = drawCard();
        int playerCard3 = drawCard();
        int playerCard4 = drawCard();
        int playerCard5 = drawCard();
        //generates computer cards
        int computerCard1 = drawCard();
        int computerCard2 = drawCard();
        int computerCard3 = drawCard();
        int computerTotal = computerCard1 + computerCard2 + computerCard3;
        //creates input variables for loop
        String userInput = "";
        int counter = 2;
        int sumOfCards = playerCard1 + playerCard2;
        while (!userInput.equals(STAND)) {

            if (counter == 2) {
                userInput = JOptionPane.showInputDialog(null, "Your cards are: "
                        + playerCard1
                        + ", "
                        + playerCard2
                        + ": that equal " + sumOfCards
                        + " \n enter h or s");
            } else if (counter == 3) {
                sumOfCards = sumOfCards + playerCard3;
                if (sumOfCards > MAX_NUMBER) {
                    endGame(sumOfCards, computerTotal);
                }
                userInput = JOptionPane.showInputDialog(null, "Your cards are: "
                        + playerCard1
                        + ", "
                        + playerCard2
                        + ", "
                        + playerCard3
                        + ": that equal " + sumOfCards
                        + " \n enter h or s");
            } else if (counter == 4) {
                sumOfCards = sumOfCards + playerCard4;
                if (sumOfCards > MAX_NUMBER) {
                    endGame(sumOfCards, computerTotal);
                }
                userInput = JOptionPane.showInputDialog(null, "Your cards are: "
                        + playerCard1
                        + ", "
                        + playerCard2
                        + ", "
                        + playerCard3
                        + ", "
                        + playerCard4
                        + ": that equal " + sumOfCards
                        + " \n enter h or s");
            } else if (counter == 5) {
                sumOfCards = sumOfCards + playerCard5;
                endGame(sumOfCards, computerTotal);
            }
            if (userInput.equals(HIT)) {
                counter++;
            } else if (userInput.equals(STAND)) {
                endGame(sumOfCards, computerTotal);
            }

            if (sumOfCards > MAX_NUMBER) {
                endGame(sumOfCards, computerTotal);
            }
            if (counter > 5) endGame(sumOfCards, computerTotal);

        }
    }

    public static int drawCard() {
        //returns number between 1 and 10
        final int HIGH = 10;
        final int LOW = 1;
        double seed = Math.random();
        double number = (HIGH - LOW + 1) * seed + LOW;
        int cardDraw = (int) number;
        return (cardDraw);
    }

    public static void endGame(int playerTotal, int computerTotal) {
        final int MAX_NUMBER = 21;
        // if statements to decide winner and loser
        if (playerTotal > MAX_NUMBER) {
            if (computerTotal > MAX_NUMBER) {
                JOptionPane.showMessageDialog(null, "Computer has "
                        + computerTotal + " points"
                        + "\n YOU have " + playerTotal + " points "
                        + "\n You Both Busted: TIE");
            } else {
                JOptionPane.showMessageDialog(null, "Computer has "
                        + computerTotal + " points"
                        + "\n YOU have " + playerTotal + " points \n You Busted"
                        + "\n Computer Wins");
            }
        } else if (playerTotal < MAX_NUMBER) {
            if (computerTotal > MAX_NUMBER) {
                JOptionPane.showMessageDialog(null, "Computer has "
                        + computerTotal + " points"
                        + "\n YOU have " + playerTotal
                        + " points \n computer Busted "
                        + "\n YOU WIN");
            } else {
                if (computerTotal > playerTotal) {
                    JOptionPane.showMessageDialog(null, "Computer has "
                            + computerTotal + " points"
                            + "\n YOU have " + playerTotal + " points "
                            + "\n Computer WINS");
                } else {
                    JOptionPane.showMessageDialog(null, "Computer has "
                            + computerTotal + " points"
                            + "\n YOU have " + playerTotal + " points "
                            + "\n YOU WIN");
                }
            }
        }

        System.exit(0);

    }

}
