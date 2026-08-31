import java.util.*;
public class Problem_268A 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int f=0;
		int t = in.nextInt();
		int i=0,j=0;
		int arr[] = new int[t];
		int brr[] = new int[t];
		for(i=0;i<t;i++) 
		{
			arr[i] = in.nextInt();
			brr[i] = in.nextInt();
		}
		for(i=0;i<t;i++)
		{
			for(j=0;j<t;j++)
			{
				if(j==i)
					continue;
				else 
				{
				if(arr[i]==brr[j])
					f++;
				}
			}
		}
		System.out.println(f);
	}
}