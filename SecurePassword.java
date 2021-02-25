/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securepassword;

import javax.swing.JOptionPane;

public class SecurePassword {

    static final int LETTER_START = 97;
    static final int LETTER_END = 122;
    static final int NUMBER_START = 48;
    static final int NUMBER_END = 57;
    static final int T = 84;
    static final int LOWER_T = 116;
    static final int LOWER_O = 111;

    public static void main(String[] args) {
        System.out.println((int) 'o');
        JOptionPane.showMessageDialog(null, "Welcome to Pasword secure!");
        boolean stop = false;
        while (true) {
            
            while (stop == false) {
                String checkUserInput
                        = JOptionPane.showInputDialog("Enter Your password");
                stop = checkNumberAndLetter(checkUserInput);
                checkT(checkUserInput);
            }
            

        }

    }
    private static boolean checkNumberAndLetter(String checkUserInput) {
        boolean hasLetter = false;
        boolean hasNumber = false;
        for (int i = 0; i < checkUserInput.length(); i++) {
            int numberValue = (int) checkUserInput.charAt(i);
            if (numberValue >= LETTER_START && numberValue <= LETTER_END) {
                hasLetter = true;
            } else if (numberValue >= NUMBER_START && numberValue <= NUMBER_END) {
                hasNumber = true;
            }
        }
        int number = (int) checkUserInput.charAt(0);
        System.out.println(number);
        if (hasNumber == true && hasLetter == true) {
            System.out.println("wow nice");
            return (true);
        } else {
            JOptionPane.showMessageDialog(null, "Password Entered Does Not"
                    + " Contain Both A Letter And Number. Try Again");
            System.out.println("password does not have number and/or letter");
            return (false);
        }
    }

    private static boolean checkT(String checkUserInput) {
        int TNumber = 0;
        boolean TRequirementsMet = false;
        boolean lowT = false;
        for (int i = 0; i < checkUserInput.length(); i++) {
            int numberValue = (int) checkUserInput.charAt(i);
            if (numberValue == T) {
                TNumber++;
            }
            
            //logic is flawed
            // i is stopped so value does not change
            else if (numberValue == LOWER_T){
                System.out.println("low t met");
                for (int j = 0; j < checkUserInput.charAt(i); j++) {
                    int afterT = checkUserInput.charAt(i);
                    lowT = true;
                    if(afterT == LOWER_O){
                        TRequirementsMet = true;
                    }
                }
            }
            
        }
        if(TNumber >= 2){ 
            System.out.println("2 t");
            return(true);
           
        }
        else if(TRequirementsMet == true){
            System.out.println("low");
            return(true);
        }
        else{
            System.out.println("no");
            return (false);
        }
    }

}
