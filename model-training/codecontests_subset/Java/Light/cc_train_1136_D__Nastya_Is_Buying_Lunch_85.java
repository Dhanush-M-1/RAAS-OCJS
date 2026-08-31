import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
	static Scanner scan = new Scanner(System.in);
	static int[] a, cnt;
	static ArrayList<Integer>[] G;
	
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		int n = scan.nextInt();
		int m = scan.nextInt();
		a = new int[n+1];
		cnt = new int[n+1];
		G = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			G[i] = new ArrayList<>();
			a[i] = scan.nextInt();
		}
		while(m-- > 0)
		{
			int u = scan.nextInt();
			int v = scan.nextInt();
			G[v].add(u);			
		}
		int ans = 0;
		for(int i=n;i>=1;i--)
			if(cnt[a[i]]==n-i-ans && i!=n) ans++;
			else for(int v : G[a[i]]) cnt[v]++;
		System.out.println(ans);
	}	
}