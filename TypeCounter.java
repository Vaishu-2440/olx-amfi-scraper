import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'typeCounter' function below.
     *
     * The function accepts STRING sentence as parameter.
     * 
     * This function should count and print the number of different types of characters:
     * - string: count of alphabetic characters
     * - integer: count of numeric characters  
     * - double: count of decimal points
     */

    public static void typeCounter(String sentence) {
        int stringCount = 0;  // alphabetic characters
        int integerCount = 0; // numeric characters
        int doubleCount = 0;  // decimal points
        
        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                stringCount++;
            } else if (Character.isDigit(c)) {
                integerCount++;
            } else if (c == '.') {
                doubleCount++;
            }
            // Ignore spaces and other characters
        }
        
        System.out.println("string " + stringCount);
        System.out.println("integer " + integerCount);
        System.out.println("double " + doubleCount);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = bufferedReader.readLine();

        Result.typeCounter(sentence);

        bufferedReader.close();
    }
}