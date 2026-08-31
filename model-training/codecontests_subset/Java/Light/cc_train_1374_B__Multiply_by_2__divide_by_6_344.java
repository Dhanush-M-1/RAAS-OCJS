import java.util.*;
import java.io.*;
/**
 * Submission for codeforces
 * @author abhinandanchandhok
 *
 */
public class round648_1{
	public static void main(String agrs[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int n= sc.nextInt();
			int count_2=0;
			int count_3=0;
			while(n%2==0 && n>1)
			{
				count_2++;
				n=n/2;
				
				
			}
			while(n%3==0 && n>2)
			{
				count_3++;
				n=n/3;
				
				
			}
			if(n==1)
			{
				if(count_2==count_3)
					System.out.println(count_3);
				else
					if(count_3>count_2)
					System.out.println((count_3+(count_3-count_2)));
					else
						System.out.println(-1);
			}
			
			else
				System.out.println(-1);
		}
		
		
		
	}
}