

package sales;
import javax.swing.JOptionPane;
/**
 * Sales.java - sales be like 
 * 
 * @author Jacob Head
 * @since Nov. 12, 2020
 */
public class Sales {

    /**
     * @param args the command line arguments
     */
    static int winnipeg[] = new int[10];
    static int calgary[] = new int[10];
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "welcome to Rinky Dooflingy Company",
                "Intro", 
                JOptionPane.INFORMATION_MESSAGE);
        direction();
    }
    public static void direction(){
        final int SEE_WIN_SALES = 1;
        final int SEE_CAL_SALES = 2;
        final int ENTER_WIN_SALES = 3;
        final int ENTER_CAL_SALES = 4;
        final int SEE_TOTAL_SALES = 5;
        final int QUIT = 6;
        //ask user input 
        while(true){
            String checkUserInput = JOptionPane.showInputDialog(
                  "\n(1) See Winnipeg Sales"
                + "\n(2) See Calgary Sales" 
                + "\n(3) Enter Winnipeg Sales" 
                + "\n(4) Enter Calgary Sales"
                + "\n(5) See Total Sales"
                + "\n(6) Quit" );
        int userInput = Integer.parseInt(checkUserInput);
        if (userInput == SEE_WIN_SALES){
            outputWinnipeg();
        }
        else if(userInput == SEE_CAL_SALES){
            
        }
        else if (userInput == ENTER_WIN_SALES){
            enterWinnipegSales();
        }
        else if (userInput == ENTER_CAL_SALES){
            
        }
        else if (userInput == SEE_TOTAL_SALES){
            
        }
        }
        
    }
    public static void enterWinnipegSales() {
        for (int i = 0; i < 10; i++) {
            int disNum = i + 1;
            String ui = JOptionPane.showInputDialog("Enter salse #" + disNum);
            int mainUI = Integer.parseInt(ui);
            winnipeg[i] = mainUI;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(winnipeg[i]);
        }
    }
    public static void outputWinnipeg(){
        try{
            JOptionPane.showMessageDialog(null, "Size 1: " + winnipeg[0]
                        + "\nSize 2: " + winnipeg[1]
                        + "\nSize 3: " + winnipeg[2]
                        + "\nSize 4: " + winnipeg[3]
                        + "\nSize 5: " + winnipeg[4]
                        + "\nSize 6: " + winnipeg[5]
                        + "\nSize 7: " + winnipeg[6]
                        + "\nSize 8: " + winnipeg[7]
                        + "\nSize 9: " + winnipeg[8]
                        + "\nSize 10: " + winnipeg[9]);
    
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "Enter Winnipeg Values Before viewing");
        }
        
    }
}

