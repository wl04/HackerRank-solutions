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
    public static int maximumToys(List<Integer> prices, int k) {
        int sum = 0, count = 0;
        quickSort(prices, 0, prices.size() - 1);
        
        // In sorted array we just count the sum until it reaches k
        for (Integer pr : prices) {
            if (sum + pr < k) {
                sum += pr;
                count++;
                System.out.println(sum + " " + count);
            } else break;
        }

        return count;
    }
    
    // Quicksort
    public static void quickSort(List<Integer> array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot -1);
        quickSort(array, pivot + 1, end);    
    }
    
    // Finding pivot
    static int partition(List<Integer> array, int begin, int end) {
        int pivot = end;
        int counter = begin;
        
        for (int i = begin; i < end; i++) {
            if (array.get(i) < array.get(pivot)) {
                int temp = array.get(counter);
                array.set(counter, array.get(i));
                array.set(i, temp);
                counter++;
            }    
        }
        int temp = array.get(pivot);
        array.set(pivot, array.get(counter));
        array.set(counter, temp);
        
        return counter;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
