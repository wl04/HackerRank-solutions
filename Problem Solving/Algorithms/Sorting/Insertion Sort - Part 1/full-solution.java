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
    public static void insertionSort1(int n, List<Integer> arr) {
        int insValue = arr.get(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) < insValue) {
                arr.set(i + 1, insValue);
                printArray(arr);
                break;
            }
            else {
                arr.set(i + 1, arr.get(i));
                printArray(arr);
                if (i == 0) {
                    arr.set(i, insValue);
                    printArray(arr);
                }
            }   
        }    
    }
    
    public static void printArray(List<Integer> arr) {
        for (Integer num : arr) {
            System.out.print (num + " ");
        }
        System.out.println();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
