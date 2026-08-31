

import java.util.Scanner;

public class Electiobs {
	
	public static void main(String [] args)
	{
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int [] a = new int [n];
		int max = 0;
		int sum1 = 0;
		for(int i = 0; i < n; i++)
		{
			a[i] = reader.nextInt();
			if(a[i] > max)
				max = a[i];
			sum1 += a[i];
		}
		
		int k = max;
		int sum2 = 0;
		while(true)
		{
			for(int i : a)
				if(i < k)
					sum2 += k-i;
			if(sum2 > sum1)
				break;
			sum2 = 0;
			k++;
		}
		
		System.out.println(k);
		
		
		
		
		
	}

}
