import java.util.Scanner;

public class runPrize{
	static public void main(String args[])
	{
		Scanner rdi = new Scanner(System.in);
		int n = rdi.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++)
		{
			arr[i] = rdi.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		int secs = 0;
		if(min<=1000000/2 && max<=1000000/2)
		{
			int curr = 1;
			for(int i=0; i<n; i++)
			{
				int next = arr[i];
				secs+=(next-curr);
				curr = arr[i];
			}
		}
		else if(min<=1000000/2 && max>1000000/2)
		{
			int currLess = 1;
			int currMore = 1000000;
			int secL = 0;
			int secM = 0;
			for(int i=0; i<n; i++)
			{
				if(arr[i]<=1000000/2)
				{
					int next = arr[i];
					secL+=(next-currLess);
					currLess = arr[i];
				}
				else
					break;
			}
			for(int i=n-1; i>=0; i--)
			{
				if(arr[i]>1000000/2)
				{
					int prev = arr[i];
					secM+=(currMore-prev);
					currMore = prev;
				}
				else
					break;
			}
			secs = Math.max(secM, secL);
		}
		else
		{
			int currMore = 1000000;
			for(int i=n-1; i>=0; i--)
			{
				int prev = arr[i];
				secs+=(currMore-prev);
				currMore = prev;
			}	
		}
		System.out.println(secs);
	}
}