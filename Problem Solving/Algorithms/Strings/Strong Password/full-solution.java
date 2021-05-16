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
    public static int minimumNumber(int n, String password) {
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        
        int addDigit = 1, addLowerCase = 1, addUpperCase = 1, addSpecial = 1;
        
        for (int i = 0; i < n; i++) {
            String ch = Character.toString(password.charAt(i));
            if (numbers.contains(ch) && addDigit != 0) addDigit -= 1;
            if (lower_case.contains(ch) && addLowerCase != 0) addLowerCase -= 1;
            if (upper_case.contains(ch) && addUpperCase != 0) addUpperCase -= 1;
            if (special_characters.contains(ch) && addSpecial != 0) addSpecial -= 1;
        }
        
        int needToAdd = addDigit + addLowerCase + addUpperCase + addSpecial; 
        
        if (n >= 6) {
            return needToAdd;    
        }
        else if (6 - n < needToAdd) {
            return needToAdd;
        }
        else {
            return (6 - n);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
