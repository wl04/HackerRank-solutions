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
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    
    // Solution
    public static int countingValleys(int steps, String path) {
        int numOfValleys = 0;
        int h = 0;
        boolean stepOverSeaLevel = true;
   
        for (int i = 0; i < path.length(); i++) {
            
            // Change h according to path
            if (path.charAt(i) == 'U') {
                h++;
            }
            else if (path.charAt(i) == 'D') {
                h--;
            }
            
            // if we step over sea level to negative h then it's a valley
            if (h < 0 && stepOverSeaLevel == true) {
                numOfValleys++;
            } 
            
            // Changing step over flag
            if (h == 0) {
                stepOverSeaLevel = true;    
            } else if (h > 0 || h < 0) {
                stepOverSeaLevel = false;
            }  
        }
        return numOfValleys;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
