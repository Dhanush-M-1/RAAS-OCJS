import java.util.*;
import java.util.stream.IntStream;

public class elections {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		for(int i = 0; i < n; i++)
		{
			s[i] = sc.nextInt();
		}
		Arrays.sort(s);
		int k = findk(s, n);
		System.out.println(k);

	}

	public static int findk(int[] s, int n) {
		int k = s[n-1];
		int evotes = IntStream.of(s).sum();
		int avotes = cavotes(s, n, k);;
		while(avotes <= evotes)
		{
			k++;
			avotes = cavotes(s, n, k);
		}
		return k;
	}
	public static int cavotes(int[] s, int n, int k)
	{
		int avotes = 0;
		for(int i = n - 1; i >= 0; i--)
		{
			avotes += k - s[i];
		}
		return avotes;
	}
}
