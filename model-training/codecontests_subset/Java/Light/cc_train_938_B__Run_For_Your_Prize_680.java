import java.util.Scanner;

public class RunForYourPrize {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a=1;
		int b=1000000;
		int x[]=new int[n];
		int i;
		int maxim=0;
		for(i=0;i<n;i++)
			x[i]=sc.nextInt();
		
		for(i=0;i<n;i++)
		{
			int max1,max2;
			if(a<x[i])max1=x[i]-a;
			  else max1=a-x[i];
			if(b<x[i])max2=x[i]-b;
			  else max2=b-x[i];
			if(max1>max2)
				{
				if(maxim<max2)maxim=max2;
				}
			else if(maxim<max1)maxim=max1;
		}
		System.out.print(maxim);
	}
}