import java.util.*;

public class helloWorld 
{
	static int n, ans, used[];
	static ArrayList<Integer>[] ar;
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ar = new ArrayList[n+1];
		used = new int[n+1];
		
		for(int i = 1; i <= n; i++)
			ar[i] = new ArrayList<Integer>();
		
		int a = 0, b = 0;
		for(int i = 1; i <= m; i++) {
			a = in.nextInt();
			b = in.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		
		for(int i = 1; i <= n; i++)
			if(used[i] == 0)
				dfs(i, 1);
		
		a = b = 0;
		for(int i = 1; i <= n; i++) {
			if(used[i] == 1)
				a++;
			if(used[i] == -1)
				b++;
		}
		
		if(ans == -1)
			System.out.println(ans);
		else {
			System.out.println(a);
			for(int i = 1; i <= n; i++)
				if(used[i] == 1)
					System.out.printf("%d ", i);
			System.out.println("\n" + b);
			for(int i = 1; i <= n; i++)
				if(used[i] == -1)
					System.out.printf("%d ", i);
		}
		
		in.close();
	}
	public static void dfs(int a, int flag)
	{
		if(used[a] != 0)
			return;
		used[a] = flag;
		for(int i = 0; i < ar[a].size(); i++) {
			int x = ar[a].get(i);
			if(used[x] == flag)
				ans = -1;
			dfs(x, -1 * flag);
		}
	}
}