//greedy array is given sorted here and dp it depend on previous and next state
import java.io.*;
import java.util.*;
public class Woodcutters
{
	public static void main(String[] f)
	{
		Scanner sc=new Scanner(System.in);
		long dpindex=Integer.MIN_VALUE,dp=0,tree[],height[];
		int i,n;
		n=sc.nextInt();
		tree=new long[n];
		height=new long[n];
		for(i=0;i<n;i++)
		{
			tree[i]=sc.nextLong();
			height[i]=sc.nextLong();
		}
		if(n>0)
		{
			dp=1;
			dpindex=(tree[0]+1);
		}
		for(i=1;i<n;i++)
		{
			if(dpindex>Integer.MAX_VALUE)
			break;
			if((tree[i]-height[i])>=dpindex)
			{
				dpindex=(tree[i]+1);
				dp++;
			}
			else if(i<(n-1) && ((tree[i]+height[i])<tree[i+1]) && tree[i]>=dpindex)
			{
				dpindex=(tree[i]+height[i]+1);
				dp++;
			}
			else if(i==(n-1) && tree[i]>=dpindex)
				dp++;
			else
				dpindex=(tree[i]+1);
			
		}
		System.out.println(dp);
	}
}