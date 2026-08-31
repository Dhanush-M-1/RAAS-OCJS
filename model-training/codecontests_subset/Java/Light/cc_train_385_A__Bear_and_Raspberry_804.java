import java.util.Scanner;
public class Solution{
    public static int maxRaspberries(int[] prices,int c)
	{
		int maxRaspberries=Integer.MIN_VALUE;
		for(int i=0;i<prices.length-1;i++)
		{
			int remainingRaspberries=prices[i]-prices[i+1]-c;
			if(remainingRaspberries>=0)
			{
				if(remainingRaspberries>maxRaspberries)
				{
					maxRaspberries=remainingRaspberries;
				}
			}
		}
		if(maxRaspberries==Integer.MIN_VALUE)
			return 0;
		return maxRaspberries;
	}
    public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int c=s.nextInt();
		int[] prices=new int[n];
		for(int i=0;i<n;i++)
		{
			prices[i]=s.nextInt();
		}
		System.out.println(maxRaspberries(prices,c));
    }
}