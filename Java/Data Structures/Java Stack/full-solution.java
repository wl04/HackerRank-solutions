import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		Stack<Character> stk = new Stack<>();
        
		while (sc.hasNext()) {
			String input=sc.next();
            if (input.isEmpty()) {
                System.out.println("true"); // Always true if we have epmpty string   
            }
            else {
                for (int i = 0; i < input.length(); i++) {
                    if (!stk.isEmpty()) { // Checking if stack is empty to prevent error
                        switch (input.charAt(i)) {
                            // we pop for closing parantheses
                            case ')':
                                if (stk.peek() == '(') {stk.pop();}     
                                break;
                            case ']':
                                if (stk.peek() == '[') {stk.pop();}     
                                break;
                            case '}':
                                if (stk.peek() == '{') {stk.pop();}     
                                break;   
                            // we push for opening parantheses
                            case '(':
                            case '[':
                            case '{':
                                stk.push(input.charAt(i)); 
                                break; 
                        }
                    }
                    else {
                        stk.push(input.charAt(i));
                    } 
                }
                // If stack is empty then all parentheses are balanced
                System.out.println(stk.isEmpty()); 
                stk.clear(); // dont forget to empty stack    
            }
		}
	}
}
