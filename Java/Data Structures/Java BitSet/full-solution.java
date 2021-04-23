import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        BitSet b1 = new BitSet(n); 
        BitSet b2 = new BitSet(n);
        BitSet[] bitSetArr = new BitSet[2];
        bitSetArr[0] = b1;
        bitSetArr[1] = b2;
        
        int m = scan.nextInt();
        scan.nextLine(); // skip \n after nextInt
        
        for (int i = 0; i < m; i++) {
            String operation = scan.next();
            int op1 = scan.nextInt();
            int op2 = scan.nextInt();   
            
            switch (operation) {
                case "AND":
                    bitSetArr[op1 - 1].and(bitSetArr[op2 - 1]);                    
                    break;
                case "OR":
                    bitSetArr[op1 - 1].or(bitSetArr[op2 - 1]);
                    break;
                case "XOR":
                    bitSetArr[op1 - 1].xor(bitSetArr[op2 - 1]);
                    break;
                case "FLIP":
                    bitSetArr[op1 - 1].flip(op2);
                    break;
                case "SET":
                    bitSetArr[op1 - 1].set(op2);
                    break;
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        
        scan.close();
    }
}
