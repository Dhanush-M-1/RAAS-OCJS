import java.util.*;
import java.io.*;
/**
 * Submission for codechef
 * @author abhinandanchandhok
 *
 */
public class Solution {
	public static void main(String agrs[])
	{
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		for(int i = 0; i < t; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int sum=0;
			while( c>=2 && b>=1)
			{
				b--;
				c=c-2;
				sum+=3;
			}
			 while( b>=2 && a>=1)
			{
				a--;
				b=b-2;
				sum+=3;
			}
			 System.out.println(sum);
			
		
	}
	}
}
