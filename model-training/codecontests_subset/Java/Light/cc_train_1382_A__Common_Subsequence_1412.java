import java.util.*;
public class Subsequence2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x=1;x<=t;x++)
		{
		    int m = sc.nextInt();
			int n = sc.nextInt();
			int[] a = new int[m];
			int[] b = new int[n];
			for(int i=0;i<m;i++)
			{
				a[i] = sc.nextInt();
			}
		    for(int i=0;i<n;i++)
			{
				b[i] = sc.nextInt();
			}
			Arrays.sort(a);
			Arrays.sort(b);
		    int count=0,res=0;
		    for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(a[i]==b[j])
					{
						count += 1;
						res = a[i];	
					}
				}
			}
			System.out.println(count==0?"NO":"YES"+"\n"+"1 "+res);	
		}
	}
}