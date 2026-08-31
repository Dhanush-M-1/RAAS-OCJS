import java.util.*;
import java.io.*;
public class a 
{
	public static void main(String[] arg)
	{
		new a();
	}
	public a()
	{
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		HashSet<Integer> hs = new HashSet<Integer>();
		int n = in.nextInt();
		int m = in.nextInt();
		for(int i = 0; i < n; i++)
		{
			int v = in.nextInt();
			for(int j = 0; j < v; j++)
			{
				hs.add(in.nextInt());
			}
		}
		out.println(hs.size()==m ? "YES":"NO");
		in.close(); out.close();
	}
}
