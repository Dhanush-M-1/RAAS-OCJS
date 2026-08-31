import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		
		for(int i = 0; i < n; i++)
			ar[i] = in.nextInt();
		Arrays.sort(ar);
		
		int[] p = new int[2];
		int t = 0, m = 0;
		for(int i = 0; i < n; i++)
			p[ ar[i]%2 ]++;
		
		if(p[0] < p[1]) {
			t = 1;
			m = p[1] - p[0] - 1;
		}
		if(p[0] > p[1]) {
			t = 0;
			m = p[0] - p[1] - 1;
		}
		
		int ans = 0;
		for(int i = 0; i < n && m > 0; i++)
			if(ar[i] % 2 == t) {
				ans += ar[i];
				m--;
			}
		
		System.out.println(ans);
		
		in.close();
	}
}

