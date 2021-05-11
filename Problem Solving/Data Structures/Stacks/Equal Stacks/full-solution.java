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
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Getting sum of elements in each array
        int sum1 = 0, sum2 = 0, sum3 = 0;
        sum1 = sumOfElements(h1);
        sum2 = sumOfElements(h2);
        sum3 = sumOfElements(h3);
        
        // Comparing sums and decreasing stacks
        boolean flag = true;
        while (flag) {
            if (sum1 == sum2 && sum1 == sum3) {
                flag = false;
                return sum1;
            } 
            else if (sum1 >= sum2 && sum1 >= sum3) {
                int value = h1.remove(0);
                sum1 -= value;
                continue;
            }
            else if (sum2 >= sum1 && sum2 >= sum3) {
                int value = h2.remove(0);
                sum2 -= value;
                continue;
            }
            else if (sum3 >= sum1 && sum3 >= sum2) {
                int value = h3.remove(0);
                sum3 -= value;
                continue;
            }
            else return 0;    
        }
        return 0;
    }
    
    // Sum array
    public static int sumOfElements(List<Integer> arr) {
        int sum = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
