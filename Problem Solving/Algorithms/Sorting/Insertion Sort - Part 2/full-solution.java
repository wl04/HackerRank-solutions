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
    public static void insertionSort2(int n, List<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int j = i;
            int value = array.get(i);
            while (j >= 1 && array.get(j - 1) > value) {
                array.set(j, array.get(j - 1));
                j--;
            }
            array.set(j, value);
            printArr(array);
        }
    }
 
    public static void printArr(List<Integer> arr) {
        for (Integer num : arr) {
            System.out.print(num + " ");
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

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
