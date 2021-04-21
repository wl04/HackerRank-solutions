import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
import static java.lang.System.in; // To deal with compile time error importing as static

class Prime {
    public static void checkPrime(int ... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            boolean flag = false;
           
            // No number is divisible by more than half of itself. So we need to loop through just num / 2            
            for (int div = 2; div <= num / 2; div++) {
                if (num % div == 0) {
                    flag = true;
                    break;
                }
            }
            
            if (num == 1) {
                flag = true;
            }
            
            if (!flag) {
                System.out.print(num + " ");
            }   
        }
        System.out.println();
    }
}

public class Solution {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
