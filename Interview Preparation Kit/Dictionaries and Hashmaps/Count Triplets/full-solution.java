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

public class Solution {

    // Solution
    static long countTriplets(List<Long> arr, long r) {
        if (arr.size() < 3) return 0;
        
        long count = 0;
        HashMap<Long, Long> freqMap = new HashMap<>();
        HashMap<List<Long>, Long> pairsMap = new HashMap<>();
        
        // Making frequency map for all array elements
        for (int i = arr.size() - 1; i >= 0; i--) {     
            long x = arr.get(i);
            long r_x = x * r;
            long r_r_x = r_x * r; 
        
            // Calculating pair
            r_x = r*x;
            r_r_x = r*r_x;
            List<Long> pair = Arrays.asList(r_x, r_r_x);

            // x is the first element (x, x*r, x*r*r)
            if (pairsMap.containsKey(pair)) {
                count += pairsMap.get(pair);  
                System.out.println(x + " " + r_x + " " + r_r_x);  
            }
            
            // x is the second element (x/r, x, x*r)
            pair = Arrays.asList(x, r_x);
            if (pairsMap.containsKey(pair)) {
                pairsMap.put(pair, pairsMap.get(pair) + freqMap.get(r_x));
            }
            else if (freqMap.containsKey(r_x)) {
                pairsMap.put(pair, freqMap.get(r_x));
            }
        
            // Calculating freq for each x in initial array
            // x is the third element (x/(r*r), x/r, x)
            if (freqMap.containsKey(x)) {
                freqMap.put(x, freqMap.get(x) + 1);
            }
            else {
                freqMap.put(x, 1L);     
            }  
        }
        //System.out.println(freqMap);
        //System.out.println(pairsMap);
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
