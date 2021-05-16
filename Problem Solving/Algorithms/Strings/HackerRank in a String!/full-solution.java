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
    public static String hackerrankInString(String s) {
        Queue<Character> hrQ = new ArrayDeque<>();
        String hr = "hackerrank";
        
        if (s.length() < hr.length()) {
            return "NO";
        }
        
        for (int i = 0; i < hr.length(); i++) {
            hrQ.add(hr.charAt(i));
        }
        // using FIFO to determine if the order is correct
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == hrQ.peek()) {
                hrQ.poll();
            }
            if (hrQ.size() == 0) {
                return "YES";
            }
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
