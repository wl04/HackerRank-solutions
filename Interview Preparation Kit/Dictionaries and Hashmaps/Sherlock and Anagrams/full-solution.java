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
    public static int sherlockAndAnagrams(String s) {
        List<String> subStrLst = new ArrayList<>();
        int count = 0;
        
        // Getting all substrings of s adding them to List 
        for (int i = 0; i < s.length(); i++) {
            String subStr = Character.toString(s.charAt(i));  
            subStrLst.add(subStr);
            if (i == s.length()) break; // no need to iterate after last char

            for (int j = i + 1; j < s.length(); j++) {
                subStr += Character.toString(s.charAt(j)); 
                if (!subStr.equals(s)){
                    subStrLst.add(subStr);
                } 
            }
        }
               
        //System.out.println(subStrLst);
        
        // Counting anagrams
        for (int i = 0; i < subStrLst.size(); i++) {
            for (int j = i; j < subStrLst.size(); j++) {
                // Different length = not anagrams
                if ((i != j) && subStrLst.get(i).length() == subStrLst.get(j).length()
                && isAnagram(subStrLst.get(i), subStrLst.get(j))) {
                    count += 1;       
                }
            }
        }
        return count;
                  
    }
    
    public static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        
        // Making HashMap for characters of s1
        for (int i = 0; i < s1.length(); i++) {
            if (!hm1.containsKey(s1.charAt(i))) {
                hm1.put(s1.charAt(i), 1);
            }
            else {
                int value = (int)hm1.get(s1.charAt(i));
                hm1.put(s1.charAt(i), value + 1);
            }    
        }
        
        // Making HashMap for characters of s2
        for (int j = 0; j < s2.length(); j++) {
            if (!hm2.containsKey(s2.charAt(j))) {
                hm2.put(s2.charAt(j), 1);
            }
            else {
                int value = (int)hm2.get(s2.charAt(j));
                hm2.put(s2.charAt(j), value + 1);
            }    
        }
        
        // If HashMaps are equal then s1 and s2 are anagrams
        return hm1.equals(hm2);
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

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
