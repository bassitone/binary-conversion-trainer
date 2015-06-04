/*
 * @(#)BinaryConversionTrainer.java
 * @author Charles Herrera
 * @version 1.00 23 February 2015 at 13:22
 * Program Purpose: Solves Reddit Daily Programmer Challenge #202 found at http://goo.gl/bbII6N.
 * Extended to test binary conversion skills useful in networking and telecommunications
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.JFrame;
import java.util.ArrayList;

public class BinaryConversionTrainer
{

    public static void main(String [] args)
    {

        //declare all the things

        Scanner input = new Scanner(System.in);
        char toContinue = 'Y';
        char binaryChoice = ' ';
        char sample = ' ';
        int hasAscii = 3;
        int sampleCounter = 0;
        char continueTo = ' ';

        String answer = "";
        String activeExercise = "";
        String decimalResult = "";
        Converter aConverter = new Converter();



        do
        {
            //decide if we want to go with sample inputs from the spec
            System.out.printf("Would you like to work on a sample exercise?%n");
            sample = input.nextLine().charAt(0);

            //we do
            if(Character.toUpperCase(sample) == 'Y')
            {

                System.out.printf("%nOkay, we'll work on a sample problem.  Would you like to start " +
                        "with a value already in binary?");
                binaryChoice = input.nextLine().charAt(0);

                //yes, binary to decimal/ASCII
                if(Character.toUpperCase(binaryChoice) == 'Y')
                {

                    //prompt user to get an ASCII conversion table
                    hasAscii(hasAscii);
                    //end Ascii check

                    System.out.printf("%nAlright, here we go.%nEach of the following sets of 8 bits" +
                            " represents a character in the ASCII character set.%n" +
                            "Convert each byte to its decimal equivalent,%n" +
                            "then use those numbers from 0 to 255 "
                            + "to find the corresponding ASCII character.");

                    do
                    {

                        activeExercise = aConverter.getBinaryExercise(sampleCounter);

                        System.out.printf("%nHere's your challenge: %s%nPlease enter your answer here:",
                                activeExercise);

                        String activeExerciseHelper = "";

                        for(int index = 0; index < activeExercise.length(); index++)
                        {
                            activeExerciseHelper = activeExercise.replaceAll("[,\\[\\] ]", "");
                        }

                        answer = input.nextLine();

                        decimalResult = aConverter.convertToDecimal(activeExerciseHelper);

                        System.out.println(decimalResult);

                        System.out.printf("The English translation of those values is: %s",
                                aConverter.getEnglishTranslation(decimalResult));

                        //more exercises?
                        boolean valid = false;

                        while(!valid)
                        {

                            System.out.printf("%nWould you like to try another exercise?");
                            continueTo = input.nextLine().charAt(0);

                            switch (Character.toUpperCase(continueTo))
                            {
                                case 'Y':
                                    sampleCounter++;
                                    valid = true;
                                    break;
                                case 'N':
                                    sampleCounter += 3;
                                    valid = true;
                                    break;
                                default:
                                    System.out.printf("%nSorry.  Please enter 'yes' or 'no' and try again.%n");
                                    valid = false;
                            }
                        }

                    } while(sampleCounter < 3);


                    //System.out.printf("DEBUG: helloWorldBinary: %s", helloWorldBinary);

                }//end if

                else //going TO binary from decimal/ASCII
                {



                }//end else

            }

            //decide whether we are going to or from binary
            System.out.printf("Are you starting with a value already in binary?%n");
            binaryChoice = input.nextLine().charAt(0);

            //yes, binary to decimal/ASCII
            if(Character.toUpperCase(binaryChoice) == 'Y')
            {


            }//end if

            else //going TO binary from decimal/ASCII
            {

            }//end else

            System.out.printf("%n Would you like to continue?");
            toContinue = input.nextLine().charAt(0);

        }
        while(Character.toUpperCase(toContinue) == 'Y');
        //end main do/while

        System.exit(0);

    }//end main()

    public static void hasAscii(int hasAscii)
    {
        while(hasAscii !=0)
        {
            hasAscii = JOptionPane.showConfirmDialog(null, "Alright, you will need an ASCII table for this.\nGo ahead and Google one, I can wait.\nPlease let me know when you are ready");

            //System.out.printf("%nDEBUG: n = %d%n", hasAscii);


            //if user cancels, exit program
            if(hasAscii == 2)
            {
                JOptionPane.showMessageDialog(null, "Alright then.  Goodbye!");
                System.exit(0);
            }

        }
    }
}//end application class BinaryConversionTrainer

