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
    public static int jumpingOnClouds(List<Integer> c) {
        int numberOfSteps = 0;
        int numberOfClouds = c.size();
        int i = 0;
        
        while (i < numberOfClouds) {
            // Determining max and min step to prevent out of bounds error
            int maxStep = numberOfClouds - 2 - i - 1;
            int minStep = numberOfClouds - 1 - i - 1;
            
            // If max step possible 
            if (maxStep >= 0 && c.get(i + 2) != 1) {
                numberOfSteps++;
                i += 2;
                continue;
            } //If min step possible
            else if (minStep >= 0 && c.get(i + 1) != 1) {
                numberOfSteps++;
                i += 1;
                continue;
            }
            else i+= 1;
        }
        return numberOfSteps;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
