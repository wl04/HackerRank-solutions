import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return possibleToSolve(leap, game, 0); // Starting at index 0
    }
    
    private static boolean possibleToSolve(int leap, int[] game, int i) {
        // We stepped over the game length = win
        if (i >= game.length) {
            return true;
        // We either moved below the min index or value at index 1 = fail
        } else if (i < 0 || game[i] == 1) {
            return false;
        }
        
        game[i] = 1; // 1 means we checked this index
        
        // Recursion from most preferable, to least: leap, +1, -1
        return possibleToSolve(leap, game, i + leap) || 
               possibleToSolve(leap, game, i + 1) ||
               possibleToSolve(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
