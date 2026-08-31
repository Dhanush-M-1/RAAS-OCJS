

import java.util.Scanner;
public class MinimumK {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int num=input.nextInt();
		int[] arr=new int[num];
		int minK=-999;
		int sum=0;
		for (int i=0;i<arr.length;++i)
		{
			arr[i]=input.nextInt();
			sum+=arr[i];
			if (minK < arr[i])
				minK=arr[i];
		}
		boolean flag=false;
		
		while(!flag)
		{
			int sum1=0;
			for (int i=0;i<arr.length;++i)
				sum1+=minK-arr[i];
			if (sum1>sum)
				flag=true;
			else
				minK++;
		}
		System.out.println(minK);
	}
}
