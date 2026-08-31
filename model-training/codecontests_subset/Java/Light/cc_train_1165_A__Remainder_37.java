/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;

public class Sol {
    
public static void main(String args[] ){
	
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int x=s.nextInt();
	int y=s.nextInt();
	
	String input=s.next();
	int ans=0;
	
	for(int i=0;i<=x-1;i++)
	{
		if(i==y)
		{
			if(input.charAt(input.length()-i-1)=='0')
			{
				ans++;
			}
		}
		else
		{
			if(input.charAt(input.length()-i-1)=='1')
				ans++;
		}
	}
	
	System.out.println(ans);
	
   }
}
