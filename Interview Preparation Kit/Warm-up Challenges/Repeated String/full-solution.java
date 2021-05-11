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

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    // Solution
    public static long repeatedString(String s, long n) {
        // Special case
        if (s.equals("a")) return n;
        
        long numOfA = 0L;
        long len = s.length();
        long evenOcc = n / len; // even number of occurancies of s in result string
        long remCharNum = n % len; // number of remaining characters
        
        // Counting 'a' occurancies in initial string
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') numOfA++;    
        }

        numOfA *= evenOcc; // biggest part of 'a' occurancies
    
        // Counting 'a' occurancies in remaining string
        String remStr = s.substring(0, (int)remCharNum);
        for (int j = 0; j < remStr.length(); j++) {
            if (remStr.charAt(j) == 'a') numOfA++;
        } 
        return numOfA;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
