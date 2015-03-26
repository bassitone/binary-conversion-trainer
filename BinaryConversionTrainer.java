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
    Random ipAddressGenerator = new Random();
    int firstOctet = 0;
    int secondOctet = 0;
    int thirdOctet = 0;
    int fourthOctet = 0;
    Scanner input = new Scanner(System.in);
    char toContinue = 'Y';
    char binaryChoice = ' ';
    char sample = ' ';
    int hasAscii = 3;
    String answer = "";
    String decimalResult = "";
    
    
    String helloWorldBinary = "01001000"+"01100101"+"01101100"+"01101100"+"01101111"+"00100000"+"01010111"+"01101111"+"01110010"+"01101100"+"01100100";
    
    String testBinaryOne = "01110000 01101100 01100101 01100001 01110011 "
      + "01100101 00100000 01110100 "
      + "01100001 01101100 01101011 "
      + "00100000 01110100 01101111 "
      + "00100000 01101101 01100101";
    
    String testBinaryTwo = "01101100 01101001 01100110 01100101 00100000 "
      + "01110010 01101001 01100111 "
      + "01101000 01110100 00100000 "
      + "01101110 01101111 01110111 "
      + "00100000 01101001 01110011 "
      + "00100000 01101100 01101111 "
      + "01101110 01100101 01101100 01111001";
    
    do
    {
      //decide if we want to go with sample inputs from the spec
      System.out.printf("Would you like to work on a sample exercise?%n");
      sample = input.nextLine().charAt(0);
      
      //we do
      if(Character.toUpperCase(sample) == 'Y')
      {
        
        System.out.printf("%nOkay, we'll work on an easy sample.  Would you like to start with a value already in binary?");
        binaryChoice = input.nextLine().charAt(0);
        
        //yes, binary to decimal/ASCII
        if(Character.toUpperCase(binaryChoice) == 'Y')
        {
          
          //prompt user to get an ASCII conversion table
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
            
          } //end Ascii check
          
          System.out.printf("%nAlright, here we go.%nEach of the following sets of 8 bits represents a character in the ASCII character set.%nConvert each byte to its decimal equivalent,%nthen use those numbers from 0 to 255 "
                              + "to find the corresponding ASCII character.");
          System.out.printf("%nHere's your first challenge: %s%nPlease enter your answer here:", helloWorldBinary);
          
          answer = input.nextLine();
          
          decimalResult = binaryToDecimal(helloWorldBinary);  //Something with this statement is throwing a StringIndexOutOfBounds exception?
          
          System.out.print(decimalResult);
          
          
          System.out.printf("DEBUG: helloWorldBinary: %s", helloWorldBinary);
          
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
  
  
  public static String binaryToDecimal(String s)
  {
    //arraylist to handle any number of characters.
    
    int length = s.length();
    String result = "";
    
    /*
     * Why ArrayList?  We can't know how long the randomly-generated binary strings will be.
     * ArrayList provides scalability
     */
    
    ArrayList <String> substrings = new ArrayList();
    ArrayList <String> decimals = new ArrayList();
    
    for(int index = 0; index < length; index++)
    {
      
      for(int placeHolder = 0; placeHolder < length; placeHolder+=8)
      {
        
        substrings.add(index, s.substring(placeHolder, placeHolder+8));
        
      }
      
      result += Integer.parseInt(substrings.get(index), 2) + ".";
      
    }
    
    System.out.println(substrings);
    
    return result;
    
  }
  
}//end application class BinaryConversionTrainer