import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			
			int[] arr=new int[n];
			
			for(int j=0;j<n;j++)
			{
				arr[j]=s.nextInt();
			}
			
			int[] pre=new int[n];
			int[] suf=new int[n];
			
			pre[0]=1;
			suf[n-1]=1;
			
			for(int j=1;j<n;j++)
			{
				if(pre[j-1]==0)
				{
					pre[j]=0;
				}
				else if(arr[j]>=j)
				{
					pre[j]=1;
				}
				else
					pre[j]=0;
			}
			
			for(int j=n-2;j>=0;j--)
			{
				if(suf[j+1]==0)
				{
					suf[j]=0;
				}
				else if(arr[j]>=n-1-j)
				{
					suf[j]=1;
				}
				else
					suf[j]=0;
			}
			
			int p=0;
			
			for(int j=0;j<n;j++)
			{
				if(pre[j]==1&&suf[j]==1)
				{
					p=1;
					break;
				}
			}
			
			if(p==0)
				System.out.println("No");
			else
				System.out.println("Yes");
			
		}
		
	}
	
}