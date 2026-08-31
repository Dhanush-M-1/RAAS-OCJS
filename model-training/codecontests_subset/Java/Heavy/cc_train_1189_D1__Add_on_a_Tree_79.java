import java.util.*;
import java.io.*;

public class d1
{
	int n;
	int[] deg;
	ArrayList<Integer>[] G;
	
	d1(Scanner in, PrintWriter out)
	{
		n = in.nextInt();
		G = new ArrayList[n];
		for (int i = 0; i < n; i++)
			G[i] = new ArrayList<>();
		deg = new int[n];
		for (int i = 0; i < n-1; i++)
		{
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			G[u].add(v);
			G[v].add(u);
			deg[u]++;
			deg[v]++;
		}
		
		boolean fail = false;
		for (int i = 0; i < n; i++)
			if (deg[i] == 2) 
				fail = true;
		
		if (fail) out.println("NO");
		else out.println("YES");
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new d1(in, out);
		out.close();
	}
}