import java.util.Scanner;

public class A915
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int i, j, tmp;
		int[] a = new int[n];

		for(i=0;i<n;i++)
			a[i]=in.nextInt();

		int max=a[0];

		for(i=0;i<n;i++)
			for(j=0;j<n-i-1;j++)
				if(a[j]>=a[j+1])
				{
					tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}

		for(i=0;i<n;i++)
			if(k%a[i]==0)
				max=a[i];

		int time=(k/max);

		System.out.println(time);
	}
}