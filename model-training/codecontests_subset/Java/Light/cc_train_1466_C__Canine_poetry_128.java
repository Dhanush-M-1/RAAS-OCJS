import java.util.Scanner;
 
public class Main
{	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			char[] in=sc.next().toCharArray();
			int n=in.length;
			int[] used=new int[n];
			int ans=0;
			for(int j=1;j<n;j++)
			{
				int use_need=0;
				if(in[j]==in[j-1] && used[j-1]==0)
					use_need=1;
				if(j>1 && in[j]==in[j-2] && used[j-2]==0)
					use_need=1;
				used[j]=use_need;
				ans+=used[j];
			}
			System.out.println(ans);
		}
	}
}