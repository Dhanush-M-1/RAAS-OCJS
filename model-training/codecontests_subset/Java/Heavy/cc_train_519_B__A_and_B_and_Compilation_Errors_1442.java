import java.util.Scanner;


public class CompilationError {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long a[] = new long[n];
		long sum1=0,sum2=0,sum3=0;
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextLong();
			a[i] = a[i] - 1000000;
			sum1 +=a[i];
		}
		for(int j=0;j<n-1;j++)
		{
			a[j] = sc.nextLong();
			a[j] = a[j] - 1000000;
			sum2 +=a[j];
		}
		for(int k=0;k<n-2;k++)
		{
			a[k] = sc.nextLong();
			a[k] = a[k] - 1000000;
			sum3 +=a[k];
		}
		long num1 = sum1 - sum2+1000000;
		long num2 = sum2 - sum3+1000000;
		
		System.out.println(num1);
		System.out.println(num2);
	}

}
