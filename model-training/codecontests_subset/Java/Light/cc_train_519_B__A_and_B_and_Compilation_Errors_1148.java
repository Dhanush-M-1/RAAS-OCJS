import java.util.Scanner;

public final class Compilation{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long sum=0;
		long sum1=0;
		long sum2=0;
		int i;
		for(i=0;i<n;i++)
			sum+=sc.nextLong();
		for(i=0;i<n-1;i++)
			sum1+=sc.nextLong();
		for(i=0;i<n-2;i++)
			sum2+=sc.nextLong();
		System.out.println(sum-sum1);
		System.out.println(sum1-sum2);
	}
}