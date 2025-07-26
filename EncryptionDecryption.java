import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'decryptMessage' function below.
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

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String encryptedMessage = bufferedReader.readLine();

        String result = Result.decryptMessage(encryptedMessage);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}