import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] ar = new int[n+1];
		
		for(int i = 1; i <= n; i++)
			ar[i] = in.nextInt();
		
		for(int i = 1; m > i; i++)
			m -= i;

		System.out.println(ar[m]);
		
		in.close();
	}
}



