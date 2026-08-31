import java.util.*;

public class ABcomp{
	public static void main(String args[])
	{
		int n;
		long suma = 0;
		long sumb = 0;
		long sumc = 0;
		int[] a;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
			suma+=a[i];
		}
		for(int i=0;i<n-1;i++)
		{
			a[i] = sc.nextInt();
			sumb+=a[i];
		}
		for(int i=0;i<n-2;i++)
		{
			a[i] = sc.nextInt();
			sumc+=a[i];
		}
		System.out.println(suma-sumb);
		System.out.println(sumb-sumc);
		
	}
}