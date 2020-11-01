/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.power;

import javax.swing.JOptionPane;

/**
 *
 * @author lazyf
 */
public class MathPower {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, 
                "At any time input 'c' to close program",
                "Important information",
                JOptionPane.INFORMATION_MESSAGE);
                
        direction();
    }

    /**
     * figures out what subject the user wants to do
     */
    public static void direction() {
        String userInput = "";

        //pre setting the levels to one
        int addLevel = 1;
        int subLevel = 1;
        int multLevel = 1;
        //levels get changed inside of while loop 

        // for reading if you passed or failed a level 
        String addAfter = "";
        String subAfter = "";
        String multAfter = "";

        boolean stop = false;

        int addPoints = 0;
        int totalPoints = 0;

        while (stop == false) {
            userInput = JOptionPane.showInputDialog(null,
                    "You Need 75 or more to pass a subject"
                    + "\n Addition = 1 " + addAfter
                    + "\n Subtraction = 2" + subAfter
                    + "\n multiplication = 3" + multAfter
                    + "\n Close Program = 4",
                    "Math Help",
                    JOptionPane.QUESTION_MESSAGE
            );
            //checks if user wants to quit
            if (userInput.equals("c"))endProgram(totalPoints);
            else if (userInput.equals("C")) endProgram(totalPoints);
            //converts user input into a number to get direction
            int direction = Integer.parseInt(userInput);
            //addition path
            if (direction == 1) {
                if (addLevel == 1) {
                    int pointValue1 = addition(1, totalPoints);
                    if (pointValue1 >= 75) {
                        addLevel = 2;
                        totalPoints = totalPoints + pointValue1;
                        addAfter = "  Passed! try next level "
                                + addLevel;
                    } else {
                        addAfter = "  Oof, better luck next time: level "
                                + addLevel;
                    }
                } else if (addLevel == 2) {
                    int pointValue2 = addition(2, totalPoints);
                    if (pointValue2 >= 75) {
                        totalPoints = totalPoints + pointValue2;
                        addLevel = 3;
                        addAfter = "  Passed! try next level "
                                + addLevel;
                    } else {
                        addAfter = "  Oof, better luck next time: level "
                                + addLevel;
                    }
                } else if (addLevel == 3) {
                    int pointValue3 = addition(3, totalPoints);
                    if (pointValue3 >= 75) {
                        totalPoints = totalPoints + pointValue3;
                        addLevel = 4;
                        addAfter = "  You Passed! Max Level Completed ";
                    }
                }

            } //subtraction path
            else if (direction == 2) {
                if (subLevel == 1) {
                    int pointValue1 = subtraction(1, totalPoints);
                    if (pointValue1 >= 75) {
                        totalPoints = totalPoints + pointValue1;
                        subLevel = 2;
                        subAfter = "  Passed! Try Next level " + subLevel;
                    } else {
                        subAfter = "  Oof, better luck next time: level "
                                + subLevel;
                    }

                } else if (subLevel == 2) {
                    int pointValue2 = subtraction(2, totalPoints);
                    if (pointValue2 >= 75) {
                        totalPoints = totalPoints + pointValue2;
                        subLevel = 3;
                        subAfter = "  Passed! Try Next level " + subLevel;
                    } else {
                        subAfter = "  Oof, better luck next time: level "
                                + subLevel;
                    }

                } else if (subLevel == 3) {
                    int pointValue3 = subtraction(3, totalPoints);
                    if (pointValue3 >= 75) {
                        totalPoints = totalPoints + pointValue3;
                        subLevel = 4;
                        subAfter = "  You Passed! Max Level Completed";
                    } else {
                        subAfter = "  Oof, better luck next time: level "
                                + subLevel;
                    }

                }

            } //for multiplication path
            else if (direction == 3) {
                if (multLevel == 1) {
                    int pointValue1 = multiplication(1, totalPoints);
                    if (pointValue1 >= 75) {
                        totalPoints = totalPoints + pointValue1;
                        multLevel = 2;
                        multAfter = "  Passed! Try Next level " + multLevel;
                    } else {
                        multAfter = "  Oof, better luck next time: level "
                                + multLevel;
                    }

                } else if (multLevel == 2) {
                    int pointValue2 = multiplication(2, totalPoints);
                    if (pointValue2 >= 75) {
                        totalPoints = totalPoints + pointValue2;
                        multLevel = 3;
                        multAfter = "  Passed! Try Next level " + multLevel;
                    } else {
                        multAfter = "  Oof, better luck next time: level "
                                + multLevel;
                    }

                } else if (subLevel == 3) {
                    int pointValue3 = multiplication(3, totalPoints);
                    if (pointValue3 >= 75) {
                        totalPoints = totalPoints + pointValue3;
                        multLevel = 4;
                        multAfter = "  You Passed! Max Level Completed";
                    } else {
                        multAfter = "  Oof, better luck next time: level "
                                + multLevel;
                    }

                }

            } else if (direction == 4) {
                endProgram(totalPoints);
            }
             
            if (addLevel == 4 && subLevel == 4 && multLevel == 4){
                stop = true;
                endProgram(totalPoints);
            }
        }

    }

    /**
     * closes program and displays total points
     * @param points Total points display
     */
    public static void endProgram(int points) {
        JOptionPane.showMessageDialog(null, "WOW Congradulations!"
                + "\n\n You Got " + points + " Points",
                "Good Job!",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    
    public static int random(int low, int high) {
        double seed = Math.random();
        double number = (high - low + 1) * seed + low;
        int randomNumber = (int) number;
        System.out.println(randomNumber);
        return (randomNumber);
    }

    /**
     * gives 10 addition questions and point value
     * @param level current addition level
     * @param totalPoints total points for if user quits
     * @return points gained 
     */
    public static int addition(int level, int totalPoints) {
        // this is for addition questions

        int low = 0;
        int high = 0;
        int points = 0;
        // if level , is for geting the number values based on level 
        if (level == 1) {
            high = 100;
            low = 1;
        } else if (level == 2) {
            high = 500;
            low = 100;
        } else if (level == 3) {
            high = 1500;
            low = 500;
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

                // calculates the answer
                int sum = number1 + number2;
                System.out.println("Answer = " + sum);
                String userInput = JOptionPane.showInputDialog(null,
                        "What Is "
                        + number1
                        + " + "
                        + number2,
                        "Answer", JOptionPane.QUESTION_MESSAGE);

                // converts userInput to int 
                
                //checks if user wants to quit
                if (userInput.equals("c"))endProgram(totalPoints);
                else if (userInput.equals("C")) endProgram(totalPoints);
               
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
                            + "\n points = " + points + "/100",
                            "Passed!", JOptionPane.INFORMATION_MESSAGE);
                    stop = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong, Try Again",
                            "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Wrong: Try Again");

                    if (counter >= 3) {
                        JOptionPane.showMessageDialog(null, "Incorrect"
                                + "\n Correct Answer was "
                                + sum
                                + "\n(points = " + points + ")",
                                "Failed!", JOptionPane.INFORMATION_MESSAGE);
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
    }
    
     /**
     * gives 10 subtraction questions and point value
     * @param level current addition level
     * @param totalPoints total points for if user quits
     * @return points gained 
     */
    public static int subtraction(int level, int totalPoints) {
        // this is for subtraction questions

        int low = 0;
        int high = 0;
        int points = 0;
        // if level , is for geting the number values based on level 
        if (level == 1) {
            high = 100;
            low = 1;
        } else if (level == 2) {
            high = 500;
            low = 100;
        } else if (level == 3) {
            high = 1500;
            low = 500;
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

                // calculates the answer
                int sum = number1 - number2;
                System.out.println("Answer = " + sum);
                String userInput = JOptionPane.showInputDialog(null,
                        "What Is "
                        + number1
                        + " - "
                        + number2,
                        "Answer", JOptionPane.QUESTION_MESSAGE);

                 //checks if user wants to quit
                if (userInput.equals("c"))endProgram(totalPoints);
                else if (userInput.equals("C")) endProgram(totalPoints);
                
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
                            + "\n points = " + points + "/100",
                            "Passed!", JOptionPane.INFORMATION_MESSAGE);
                    stop = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong, Try Again",
                            "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Wrong: Try Again");

                    if (counter >= 3) {
                        JOptionPane.showMessageDialog(null, "Incorrect"
                                + "\n Correct Answer was "
                                + sum
                                + "\n(points = " + points + ")",
                                "Failed!", JOptionPane.INFORMATION_MESSAGE);
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
    }

     /**
     * gives 10 multiplication questions and point value
     * @param level current addition level
     * @param totalPoints total points for if user quits
     * @return points gained 
     */
    public static int multiplication(int level, int totalPoints) {
        // this is for multiplication questions

        int low = 0;
        int high = 0;
        int points = 0;
        // if level , is for geting the number values based on level 
        if (level == 1) {
            high = 100;
            low = 1;
        } else if (level == 2) {
            high = 500;
            low = 100;
        } else if (level == 3) {
            high = 1500;
            low = 500;
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

                // calculates the answer
                int sum = number1 * number2;
                System.out.println("Answer = " + sum);
                String userInput = JOptionPane.showInputDialog(null,
                        "What Is "
                        + number1
                        + " * "
                        + number2,
                        "Answer", JOptionPane.QUESTION_MESSAGE);

                 //checks if user wants to quit
                if (userInput.equals("c"))endProgram(totalPoints);
                else if (userInput.equals("C")) endProgram(totalPoints);
                
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
                            + "\n points = " + points + "/100",
                            "Passed!", JOptionPane.INFORMATION_MESSAGE);
                    stop = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong, Try Again",
                            "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Wrong: Try Again");

                    if (counter >= 3) {
                        JOptionPane.showMessageDialog(null, "Incorrect"
                                + "\n Correct Answer was "
                                + sum
                                + "\n(points = " + points + ")",
                                "Failed!", JOptionPane.INFORMATION_MESSAGE);
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
