
import java.util.Arrays;
import java.util.Scanner;
//题意：n个数，每次可以任选一个数使它变为原来的一半，求最小操作数使得至少有k个数相等
//思路：，
public class Main {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int str[]=new int[n],ans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			str[i]=sc.nextInt();
		}
		Arrays.sort(str);
		int step[]=new int[200005],sum[]=new int[200005];
		for(int i=0;i<n;i++)
		{
			int temp=str[i],j=1;
			while(temp>0)
			{
				sum[temp]++;
				if(sum[temp]>=k)
					ans=Math.min(ans, step[temp]);//System.out.println(step[temp/2]+" "+step[temp]+" "+i+" "+temp);
				step[temp/2]+=j++;//System.out.println(step[temp/2]+" "+step[temp]);
				temp/=2;
			}
		}
		System.out.println(ans);
	}

}
