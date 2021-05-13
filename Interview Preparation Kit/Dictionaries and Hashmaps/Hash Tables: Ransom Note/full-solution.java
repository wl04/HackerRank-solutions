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
    public static void checkMagazine(List<String> magazine, List<String> note) {
        Hashtable<String, Integer> magazineHt = new Hashtable<>(); 
        Hashtable<String, Integer> noteHt = new Hashtable<>();                       
                
        // Placing all magazine words to hash table
        for (int i = 0; i < magazine.size(); i++) {
            if (magazineHt.containsKey(magazine.get(i))) {
                int value = magazineHt.get(magazine.get(i));
                magazineHt.put(magazine.get(i), value + 1);
            }
            else magazineHt.put(magazine.get(i), 1);
        }
        
         // Placing all note words to hash table
        for (int i = 0; i < note.size(); i++) {
            if (noteHt.containsKey(note.get(i))) {
                int value = noteHt.get(note.get(i));
                noteHt.put(note.get(i), value + 1);
            }
            else noteHt.put(note.get(i), 1);
        }
        
        // Checking if all words from note are in Hashtable and quantity is enough
        for (Map.Entry entry : noteHt.entrySet()) {
            if ((magazineHt.get(entry.getKey()) == null) ||
            (Integer)magazineHt.get(entry.getKey()) < (Integer)entry.getValue()) {
                System.out.println("No");
                return;        
            } 
        }
        System.out.println("Yes");
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
