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
     * Problem 1: Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     * 
     * Logic:
     * 1. First the words in the sentence are reversed
     * 2. For each word, adjacent repeated letters are compressed in format <character><frequency>
     * 3. Return the decrypted string
     */
    public static String decryptMessage(String encryptedMessage) {
        // Split the encrypted message into words
        String[] words = encryptedMessage.split(" ");
        
        // Process each word: decompress repeated letters
        List<String> decryptedWords = new ArrayList<>();
        
        for (String word : words) {
            StringBuilder decryptedWord = new StringBuilder();
            
            // Process each character in the word
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                
                // Check if next character is a digit (frequency)
                if (i + 1 < word.length() && Character.isDigit(word.charAt(i + 1))) {
                    int frequency = Character.getNumericValue(word.charAt(i + 1));
                    
                    // Add the character 'frequency' times
                    for (int j = 0; j < frequency; j++) {
                        decryptedWord.append(currentChar);
                    }
                    
                    // Skip the frequency digit
                    i++;
                } else {
                    // Single character without frequency
                    decryptedWord.append(currentChar);
                }
            }
            
            decryptedWords.add(decryptedWord.toString());
        }
        
        // Reverse the order of words
        Collections.reverse(decryptedWords);
        
        // Join words with spaces
        return String.join(" ", decryptedWords);
    }

    /*
     * Problem 2: Complete the 'typeCounter' function below.
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
        
        // For Problem 1: Encryption Decryption - uncomment below
        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String encryptedMessage = bufferedReader.readLine();
        String result = Result.decryptMessage(encryptedMessage);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        */
        
        // For Problem 2: Type Counter - uncomment below
        /*
        String sentence = bufferedReader.readLine();
        Result.typeCounter(sentence);
        */
        
        bufferedReader.close();
    }
}