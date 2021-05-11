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
    public static int sockMerchant(int n, List<Integer> ar) {
        int numOfPairs = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // Counting unique socks using HashMap where key is sock, value is amount 
        for (int i = 0; i < ar.size(); i++) {
            int aV = ar.get(i);
            if (!hm.containsKey(aV)) {
                hm.put(aV, 1);
            }
            else {
                int value = hm.get(aV);
                hm.put(aV, value + 1);
            }            
        }
        
        // Counting pairs
        for (Map.Entry entry : hm.entrySet()) {                
            int currentPairs = (Integer)entry.getValue() / 2; 
            if (currentPairs >= 1) {
                numOfPairs += currentPairs;
            }
        }
                
        return numOfPairs;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
