import javax.script.ScriptEngine;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Charles Herrera on 31 May 2015 at 00:08.
 *
 * This class does the processing of binary or decimal inputs to their opposite
 */
public class Converter {
    //sample problems
    private static final String helloWorldBinary = "01001000" + "01100101" + "01101100" + "01101100" +
            "01101111" + "00100000" + "01010111" + "01101111" + "01110010" + "01101100" + "01100100";

    private static final String testBinaryOne = "01110000" + "01101100" + "01100101" + "01100001" + "01110011"
            + "01100101" + "00100000" + "01110100"
            + "01100001" + "01101100" + "01101011"
            + "00100000" + "01110100" + "01101111"
            + "00100000" + "01101101" + "01100101";

    private static final String testBinaryTwo = "01101100" + "01101001" + "01100110" + "01100101" + "00100000"
            + "01110010" + "01101001" + "01100111"
            + "01101000" + "01110100" + "00100000"
            + "01101110" + "01101111" + "01110111"
            + "00100000" + "01101001" + "01110011"
            + "00100000" + "01101100" + "01101111"
            + "01101110" + "01100101" + "01101100" + "01111001";

    //instance variables
    private Random ipAddressGenerator = new Random();
    private int firstOctet = 0;
    private int secondOctet = 0;
    private int thirdOctet = 0;
    private int fourthOctet = 0;


    public Converter() {
        //default constructor, may do ~things~ with it

    }

    public Converter(int placeHolder) {

    }


    //binary to decimal
    public String convertToDecimal(String s) {
        //arraylist to handle any number of characters.

        int length = s.length();
        String result = "";

    /*
     * Why ArrayList?  We can't know how long the randomly-generated binary strings will be.
     * ArrayList provides scalability
     */

        ArrayList<String> substrings = new ArrayList<>();
        ArrayList<String> decimals = new ArrayList<>();

        for (int placeHolder = 0; placeHolder < length; placeHolder += 8) {
            int index = 0;
            substrings.add(index, s.substring(placeHolder, placeHolder + 8));


            index++;

        }

        for (String substring : substrings)
        {

            result += Integer.parseInt(substring, 2) + ".";

        }


        //Debug statement for this method: System.out.println(substrings);

        return result;

    }

    /*
        takes the result from convertToDecimal and turns them into their character values.
        Do not call me for practicing.  Real world use is fine though.
     */
    public String getEnglishTranslation(String binaryCharacters) {
        //stores the decimal characters passed to this method
        ArrayList<String> charString = new ArrayList<>();
        /*
            is using an ArrayList overkill?  Maybe a regular array will suffice
        */
        ArrayList<Integer> charValues;
        char [] castOfCharacters;

        //Debug: System.out.println("binaryCharacters: " + binaryCharacters);

        int begin = 0;


        for (int index = 0; index < binaryCharacters.length(); index++) {
            //This loop looks at binaryCharacters and extracts the decimal strings


            if (binaryCharacters.charAt(index) == '.')
            {
                charString.add(binaryCharacters.substring(begin, index));
                begin = index + 1;
            }
        }

        //Debug: System.out.println("charString: " + charString);

        charValues = new ArrayList<>(charString.size());

        for (int val = 0; val < charString.size(); val++)
        {
            //change the strings in charString to integers
            charValues.add(Integer.parseInt(charString.get(val)));
        }

        //Debug: System.out.println("charValues: " + charValues + "\n size: " + charValues.size());

        castOfCharacters = new char[charString.size()];

        //Debug: System.out.println(castOfCharacters.length);

        int convertHelper;
        for (int charValue = 0; charValue < castOfCharacters.length; charValue++)
        {
            //change the integers to their character values
            convertHelper = charValues.get(charValue);
            //Debug: System.out.println("convertHelper: " + convertHelper);
            char aCharacter = (char) convertHelper;
            castOfCharacters[charValue] = aCharacter;
        }

        //Debug: System.out.println(castOfCharacters);

        String englishResult = "";

        for (int charCount = castOfCharacters.length - 1; charCount >= 0; charCount--)
        {
            //and unify the characters in a String to send back.
            englishResult += castOfCharacters[charCount];
        }

        //System.out.println(englishResult);

        return englishResult;

    }


    public String getBinaryExercise(int sampleCount)
    {
        ArrayList<String> substrings = new ArrayList<>();
        int begin = 0;
        String example = "";
        switch (sampleCount) {
            case 0:
                for(int loc = 0; loc < helloWorldBinary.length(); loc++)
                {
                    if(loc % 8 == 0 && loc != 0)
                    {
                        substrings.add(helloWorldBinary.substring(begin, loc));
                        //substrings.add(" ");
                        begin = loc + 1;
                    }
                }
                example = substrings.toString();
                break;
            case 1:
                for(int loc = 0; loc < testBinaryOne.length(); loc++)
                {
                    if(loc % 8 == 0)
                    {
                        substrings.add(testBinaryOne.substring(begin, loc));
                        //substrings.add(" ");
                        begin = loc + 1;
                    }
                }
                example = substrings.toString();
                break;
            case 2:
                for(int loc = 0; loc < testBinaryTwo.length(); loc++)
                {
                    if(loc % 8 == 0)
                    {
                        substrings.add(testBinaryTwo.substring(begin, loc));
                        //substrings.add(" ");
                        begin = loc + 1;
                    }
                }
                example = substrings.toString();
                break;
        }

        return example;

    }
}
