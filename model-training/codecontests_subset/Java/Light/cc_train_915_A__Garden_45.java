import java.util.Arrays;
import java.util.Scanner;

public class cdf {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		int k = ob.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = ob.nextInt();
		}
		Arrays.sort(a,0,n);
		int max = a[0];
		for(int i=0;i<n;i++)
		{
			if(a[i]>k)
				break;
			if(k%a[i]==0)
				max = a[i];
		}
		System.out.println(k/max);
	}
}
