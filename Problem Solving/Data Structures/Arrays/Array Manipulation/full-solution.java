import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Solution
class Result {
    
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long maxSum = Long.MIN_VALUE;
        long k, sum = 0L;
        int a, b = 0;
        List<Long> arr = new ArrayList<Long>(Collections.nCopies(n + 1, 0L));
        
        for (int i = 0; i < queries.size(); i++) {
            a = queries.get(i).get(0);
            b = queries.get(i).get(1);
            k = queries.get(i).get(2);
        
            arr.set(a - 1, arr.get(a - 1) + k);
            arr.set(b, arr.get(b) - k);
        }      
        
        for (int j = 0; j < n; j++) {
            sum += arr.get(j);
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
