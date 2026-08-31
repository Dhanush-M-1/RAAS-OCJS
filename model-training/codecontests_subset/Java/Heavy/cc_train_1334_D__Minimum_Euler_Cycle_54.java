import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			
			long l=s.nextLong();
			long r=s.nextLong();
			
			int left=0;
			int right=0;
			
			long ll=0;
			long rr=0;
			
			long count=0;
			int block=0;
			
			while(count<l&&block<n)
			{
				block++;
				count=count+2*(n-block);
			}
			
			left=block;
			ll=count-2*(n-block);
			
			count=0;
			block=0;
			
			while(count<r&&block<n)
			{
				block++;
				count=count+2*(n-block);
			}
			
			right=block;
			rr=count;
			
			ArrayList<Integer> list=new ArrayList<>();
			
			for(int j=left;j<=right;j++)
			{
				fill(list,j,n);
			}
			
			long cc=0;
			
			for(long j=ll+1;j<=rr;j++)
			{
				int now=list.get((int)(j-(ll+1)));
				
				if(j>=l&&j<=r)
				{
					cc++;
					sb.append(now+" ");
				}
			}
			
			if(cc==r-l+1)
				sb.append("\n");
			else
			{
				sb.append(1+"\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
	public static void fill(ArrayList<Integer> list,int start,int n)
	{
		int c=start+1;
		
		for(int i=0;i<2*(n-start);i++)
		{
			if(i%2==0)
			{
				list.add(start);
			}
			else
			{
				list.add(c);
				c++;
			}
		}
	}
	
}