import java.util.InputMismatchException;
import java.util.Scanner;


public class CharSorter {


    public static void printMenu() {                                                    //easy way to print the Menu in the main method
        System.out.println();
        System.out.println("Please select the option you would like to see");
        System.out.println();
        System.out.println("1. Display frequency characters alphabetically");
        System.out.println("2. Display sorted frequencies");
        System.out.println("3. Show types of character frequencies");
        System.out.println("4. Exit");
    }


    public static void alphabeticalSort(String usInput){                                //Method: sorts the variables/frequency in alphabetical order
        int h;
        int i;                                                                          //All my for loop variables
        int k;
        int m;
        int p;
        int r;
        int s;
        int u;
        int numberOfChar;
        char charOfNumber;
        char[] charArray= usInput.toCharArray();                                        //change the string input to an array of characters
        int[] numberArray = new int[charArray.length];                                  //create an integer array with the same length as the char array
        for(h = 0; h < charArray.length; h++){                                          //for loop to put the ASCII values (of each character in the char array)
                                                                                        //into the numberArray
            numberOfChar = charArray[h];
            numberArray[h] = numberOfChar;
        }

        for(r = 0; r < numberArray.length; r++) {                                       //for loops that compare an element to all the other elements to the
                                                                                        //right of it and switches the values if the element on the right
            for(s = r + 1; s < numberArray.length; s++){                                //is smaller than the original element being evaluated.
                if (numberArray[s] < numberArray[r]) {                                  //basically it sorts the ASCII numbers in numerical order
                    int holdValue = numberArray[r];
                    numberArray[r] = numberArray[s];
                    numberArray[s] = holdValue;
                }
            }
        }
        char[] charArray2 = new char[numberArray.length];                               //creates a new character Array to put the int Array values into

        for(u = 0; u < numberArray.length; u++){                                        //for loop to fill the charArray2 with all the ASCII values from
             charOfNumber = (char)numberArray[u];                                       //the numberArray, but back into their character form
             charArray2[u] = charOfNumber;
        }

        char charType;                                                                  //keeps track of what type of character was put
        int charFreq;                                                                   //keeps track of the frequency of the character

        for (i = 0; i < charArray2.length ; i++){                                       //main for loop to iterate through the string
            charFreq = 1;                                                               //starts frequency @ 1 so it includes the current char being evaluated
            charType = charArray2[i];
            if (i == 0) {                                                               //if/else statement that separates the 1st element iteration from
                                                                                        //all the other elements' iterations.
                for (k = i + 1; k < charArray2.length ; k++) {                          //for loop to compare character 1 to all the other characters
                    if (charArray2[i] == charArray2[k]) {                               //and if they're the same, increment the frequency by 1
                        charFreq++;
                    }
                }
            }
            else {                                                                      //if we evaluate an element that ISN'T the 1st in the string:

                for(p = i+1; p < charArray2.length; p++){                               //FIRST we check the values to the right of the element and
                    if (charArray2[i] == charArray2[p]) {                               //increment if they're the same
                        charFreq++;
                    }
                }
                for (m = i-1; m >= 0; m--){
                                                                                        //THEN we check the values to the left of the element to see if
                                                                                        //it has already been evaluated. If it has, we set the charFreq to 0
                    if (charArray2[i] == charArray2[m]){                                //which means that this element will not be printed with it's frequency
                        charFreq = 0;                                                   //(due to the if loop below) BECAUSE this element's character has already
                                                                                        //been evaluated and printed before
                    }

                }

            }
            if (charFreq != 0) {                                                        //if the element has not been evaluated before, print out the
                System.out.println("" + charType + " freq: " + charFreq);               //character's frequency
            }
        }
        System.out.println();
    }


    public static void frequencySort(String usInput ) {                                 //Method: sorts the characters from highest frequency to lowest

        System.out.println("The sorted by frequency characters are: ");
        int i;                                                                          //all of my for loop variables
        int k;
        int m;
        int p;
        int r;
        int s;
        int numberOfChar;
        char[] charArray = usInput.toCharArray();                                       //change the string input to an array of characters
        int[] freqArray = new int[charArray.length];                                    //makes an array to keep track of the frequencies of each char
        int[] numberArray = new int[charArray.length];                                  //makes an array to keep track of the ASCII values of each char


        char charType;                                                                  //keeps track of what type of character was put
        int charFreq;                                                                   //keeps track of the frequency of the character

        for (i = 0; i < charArray.length; i++) {                                        //main for loop to iterate through the string
            charFreq = 1;                                                               //starts frequency @ 1 so it includes the current char being evaluated

            if (i == 0) {                                                               //if/else statement that separates the 1st element iteration from
                                                                                        //all the other elements' iterations.
                                                                                        //I want to evaluate the first element differently because it comes
                                                                                        //first in the list and therefore does not have any elements
                                                                                        //to the left of it.
                for (k = i + 1; k < charArray.length; k++) {                            //for loop to compare character 1 to all the other characters
                    if (charArray[i] == charArray[k]) {                                 //and if they're the same, increment the frequency by 1
                        charFreq++;
                    }
                }
            }
            else {                                                                      //if we evaluate an element that ISN'T the 1st in the string:

                for (p = i + 1; p < charArray.length; p++) {                            //FIRST we check the values to the right of the element and
                    if (charArray[i] == charArray[p]) {                                 //increment if they're the same
                        charFreq++;
                    }
                }
                for (m = i - 1; m >= 0; m--) {
                                                                                        //THEN we check the values to the left of the element to see if
                                                                                        //it has already been evaluated. If it has, we set the charFreq to 0
                    if (charArray[i] == charArray[m]) {                                 //which means that this element will not be printed with it's frequency
                        charFreq = 0;                                                   //(due to the if loop below) because this element's character has already
                                                                                        //been evaluated and printed before
                    }

                }

            }

            freqArray[i] = charFreq;                                                    //the frequency Array gets filled with the frequencies of each char
            numberOfChar = charArray[i];
            numberArray[i] = numberOfChar;                                              //the number Array gets filled with the ASCII values of each char

        }


        for(r = 0; r < charArray.length ; r++){                                         //next for-loop that arranges all the arrays in frequency/ASCII order.
            for(s = r+1; s < charArray.length ; s++){                                   //checks the elements to the right of the main element (at [r]).
                if (freqArray[s] != 0 && freqArray[r] != 0) {                           //If the frequencies of both numbers are NOT 0, we can evaluate
                    if (freqArray[r] < freqArray[s]) {                                  //them to see if they should be switched.
                        char holdValue = charArray[r];                                  //If the frequency is lower on the right, switch the right and left values
                        charArray[r] = charArray[s];                                    //(for ALL arrays so they can all be matching char, ASCII, and frequency
                        charArray[s] = holdValue;                                       //values)

                        int holdValue2 = freqArray[r];
                        freqArray[r] = freqArray[s];
                        freqArray[s] = holdValue2;

                        int holdValue3 = numberArray[r];
                        numberArray[r] = numberArray[s];
                        numberArray[s] = holdValue3;
                    }
                    else if (freqArray[r] == freqArray[s]) {                            //if the elements have the SAME frequency, they need to be ordered
                                                                                        //based on which comes first on the ASCII chart.
                        if (numberArray[s] < numberArray[r]) {                          //if statement to check the ASCII values against each other
                            char holdValue4 = charArray[r];                             //if the ASCII is lower on the right, switch the right and left values
                            charArray[r] = charArray[s];                                //(for ALL arrays)
                            charArray[s] = holdValue4;

                            int holdValue5 = freqArray[r];
                            freqArray[r] = freqArray[s];
                            freqArray[s] = holdValue5;

                            int holdValue6 = numberArray[r];
                            numberArray[r] = numberArray[s];
                            numberArray[s] = holdValue6;

                        }
                    }
                }
            }
            charFreq = freqArray[r];                                                    //assigns the element at position [r] in the frequency array to a variable
            charType = charArray[r];                                                    //assigns the element at position [r] in the character array to a variable

            if (charFreq != 0) {                                                        //print the frequency as long as the charFreq was not 0 (a repeated char)
                System.out.println("" + charType + " frequency: " + charFreq);
            }

        }
        System.out.println();
    }


    public static void charTypes(String usInput){                                       //Method: sorts the data into 4 categories: textual,
                                                                                        //numeric, whiteSpace, and symbolic characters
        int i;
        int textChar, numChar, whiteChar, symbolChar;
        textChar = numChar = whiteChar = symbolChar = 0;
        for (i = 0; i < usInput.length() ; i++) {                                       //the for loop to iterate through the user's input.
            if ((65 <= usInput.charAt(i) && usInput.charAt(i) <= 90) ||                 //these if statements use ASCII values to tell if
                    (97 <= usInput.charAt(i) && usInput.charAt(i) <= 122)){             //an element in the array is a textual/numeric/white/symbol
                textChar++;                                                             //and then increments a specific counter (numChar, whiteChar, etc.)
            }
            if (48 <= usInput.charAt(i) && usInput.charAt(i) <= 57){
                numChar++;
            }
            if (usInput.charAt(i) == 32){
                whiteChar++;
            }
            if ((33 <= usInput.charAt(i) && usInput.charAt(i) <= 47) ||
                    (58 <= usInput.charAt(i) && usInput.charAt(i) <= 64) ||
                    (91 <= usInput.charAt(i) && usInput.charAt(i) <= 96) ||
                    (123 <= usInput.charAt(i) && usInput.charAt(i) <= 126)){

                symbolChar++;
            }
        }

        System.out.println("Textual Character count: " + textChar);                     //prints out the counts obtained in the for loop
        System.out.println("Numeric Character count: " + numChar);
        System.out.println("WhiteSpace Character count: " + whiteChar);
        System.out.println("Symbol Character count: " + symbolChar);
        System.out.println();
    }


    public static void main(String[] args){                                             //Main method
        boolean badInput = true;
        boolean userExit = false;
        int userChoice = 0;


        System.out.println("Welcome to the Character Sorter Program");
        System.out.println("Please input a string to be sorted");

        Scanner scanner = new Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine();

        printMenu();

        while (!userExit) {                                                             //while the user hasn't chosen option 4

            if (userChoice == 1) {                                                      //execute alphabeticalSort if user chose 1
                alphabeticalSort(userInput);
                printMenu();                                                            //prints the menu for the user to choose another option
                badInput = true;                                                        //badInput allows us to go into the badInput while loop (below);
            }                                                                           //this is where the userChoice prompt/scanner is
            else if (userChoice == 2) {
                frequencySort(userInput);
                printMenu();
                badInput = true;
            }
            else if (userChoice == 3) {
                charTypes(userInput);
                printMenu();
                badInput = true;
            }
            else if (userChoice == 4){
                System.out.println();
                System.out.println("Character Sorter Exited Successfully");
                userExit = true;
            }

            while (badInput) {                                                           //while loop and try/catch block
                try {                                                                    //that scans for the user's menu choice
                    userChoice = scanner.nextInt();                                      //and catches any input that's not an int 1-4
                    if (userChoice >= 1 && userChoice <= 4) {
                        badInput = false;
                        scanner.nextLine();
                    }
                    else {
                        System.out.println("Error, bad input, please enter a number 1-4");
                        printMenu();
                        scanner.nextLine();
                    }

                } catch (InputMismatchException wrongInput) {
                    System.out.println("Error, bad input, please enter a number 1-4");
                    printMenu();
                    scanner.nextLine();
                }
            }
        }
    }
}
