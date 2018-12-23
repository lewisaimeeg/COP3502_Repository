//Program to take a hexadecimal number and convert it to decimal

import java.lang.*;

public class Lab5 {

    public static int hexDigitToDecimal(char charValues){                //method to convert ASCII values to regular
                                                                        //values, depending on if it's a number or
        int intValues = (int)charValues;                                  //a character

        if (intValues >= 97){                                            //if statement for characters
            intValues -= 87;
        }
        else if (intValues <= 59){                                       //if statement for numbers
            intValues = (int)charValues;
            intValues -= 48;
        }

        return intValues;                                                //returns the correct value to the main method
    }

    public static void main(String[] args) {
        String hexNumber = args[0];
        hexNumber = hexNumber.toLowerCase();

        if (hexNumber.charAt(1) == 'x') {                               //if statement that skips over any "0x"
            hexNumber = hexNumber.substring(2);                         //parts of a string input
        }

        int x = 0;
        long finalNumber = 0;
        for (int i = hexNumber.length() - 1; i >= 0; i--) {             //start at the right side of the hexidecimal
            char charValue = hexNumber.charAt(i);                       //and run the for loop to the left of the
                                                                        //hexidecimal until it gets to 0

            int intValue = hexDigitToDecimal(charValue);                //calls the method to convert to the actual #

            double doubleValue = intValue * Math.pow(16,x);             //multiplies each number by the appropriate
            x++;                                                        //power (16^x), then increments x


            finalNumber += (long) doubleValue;                          //adds all the values of each number
        }

        System.out.print(finalNumber + " ");                            //prints out final number

    }
}
