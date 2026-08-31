
import java.util.*;

public class Solution
{
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int inputs = sc.nextInt();
		while(inputs>0)
		{
		    
		    int firstNo = sc.nextInt();
		    int SecondNo = sc.nextInt();
		    int n = sc.nextInt();
		    
		    if(n % 3 == 0 )
		    {
		        System.out.println(firstNo);
		    }
		    if(n % 3 == 1 )
		    {
		        System.out.println(SecondNo);
		    }
		    if(n % 3 == 2 )
		    {
		        System.out.println(firstNo ^ SecondNo);
		    }
		    
		    inputs=inputs-1;
		}
		
	}
}
