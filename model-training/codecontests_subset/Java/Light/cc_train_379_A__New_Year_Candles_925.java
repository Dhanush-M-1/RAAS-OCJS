//package randomQuestions;
/* package whatever; // don't place package name! */

import java.util.*;



/* Name of the class has to be "Main" only if the class is public. */
public class BB
{	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count=0;
		int left=0;
		int temp=0;
		while(n!=0)
		{
			count+=n;
			temp=n;
			n=(n+left)/m;
			left=(temp+left)%m;
		}
		System.out.println(count);
	}
}