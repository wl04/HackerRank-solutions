import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
            
            Pattern ptrn = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher match = ptrn.matcher(line);
            
            boolean matchFound = false;
          	while (match.find()) {
                System.out.println(match.group(2));
                matchFound = true;
            }
            
            if (!matchFound) {
                System.out.println("None");                
            }
			
			testCases--;
		}
	}
}
