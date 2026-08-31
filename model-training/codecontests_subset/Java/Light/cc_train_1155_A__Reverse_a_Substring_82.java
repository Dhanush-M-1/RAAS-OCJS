

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DD {

	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		String g=scan.next();
		int freq[]=new int[26];
//		int cur=g.charAt(0);
		int cur=0;
		for(int i=1;i<n;i++)
		{
			if(g.charAt(cur)>(g.charAt(i)))
			{
				System.out.println("YES");
				System.out.println((cur+1)+" "+(i+1));
				return;
				
			}
			cur=i;
		}
		System.out.println("NO");
	}
}
