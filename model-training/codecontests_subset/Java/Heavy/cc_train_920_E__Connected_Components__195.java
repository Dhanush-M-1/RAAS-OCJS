
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class MST01 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]), m = Integer.parseInt(inp[1]);
		TreeSet<Integer>[] inv = new TreeSet[n];
		for(int i=0;i<n;i++)inv[i] = new TreeSet<Integer>();
		for(int i=0;i<m;i++)
		{
			inp = br.readLine().split(" ");
			int u = Integer.parseInt(inp[0])-1, v= Integer.parseInt(inp[1])-1;
			inv[Math.min(u, v)].add(Math.max(u, v));
		}
		ArrayList<Integer> sizes =new ArrayList<Integer>();
		int[] comps = new int[n];
		Arrays.fill(comps, 1);
		loop : for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(!inv[i].contains(j))
				{
					comps[j]+=comps[i];
					TreeSet<Integer> tmp = new TreeSet<Integer>();
					for(int x: inv[i])
						if(inv[j].contains(x))tmp.add(x);
					inv[j] = tmp;
					continue loop;
				}
			}
			sizes.add(comps[i]);
		}
		pw.println(sizes.size());
		Collections.sort(sizes);
		for(int x: sizes)
			pw.print(x+" ");
		pw.close();
		pw.flush();
	}

}
