

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
    
    public static int random(int low, int high){
        double seed = Math.random();
        double number = (high - low + 1) * seed + low;
        int randomNumber = (int) number;
        System.out.println(randomNumber);
        return (randomNumber);
    }
    
    public static void addition(int level){
        boolean stop = false;
        int counter = 0;
        while (stop == false){
            if (level == 1) {
             int number1 = random(1, 100);
             int number2 = random(1, 100);
             String userInput = JOptionPane.showInputDialog(
                        "What Is " 
                        + number1
                        + " + " 
                        + number2);
             
             int sum = number1 + number2;
             int userAnswer = Integer.parseInt(userInput);
             counter++;
             if (userAnswer == sum){
                 System.out.println("Congrats You Got it On Your " 
                        + counter
                        + " Try!");
                 JOptionPane.showMessageDialog(null, 
                        "Congrats You Got it On Your " 
                        + counter
                        + " Try!");
                 stop = true;
             }
             else {
                 JOptionPane.showMessageDialog(null, "Wrong, Try Again");
                 System.out.println("Wrong: Try Again");
             }
             if (counter == 3){
                 System.out.println("You Failed");
                 JOptionPane.showMessageDialog(null, "U Failed Loser");
                 stop = true;
             }
        }
            
        }
        
        JOptionPane.showMessageDialog(null, "HAHAH Loser Program Ended LOLLLLL");
        System.out.println("HAHAH Loser Program Ended LOLLLLL");
   
    }
    
    

}
