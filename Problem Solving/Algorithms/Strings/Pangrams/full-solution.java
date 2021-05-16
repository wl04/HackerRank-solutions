import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    // Solution
    public static String pangrams(String s) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        for (int i = 0; i < alphabet.length; i++) {
            if (s.indexOf(alphabet[i]) == -1 && 
            s.indexOf(Character.toUpperCase(alphabet[i])) == -1) {
                return "not pangram";
            }
        }   
        return "pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
