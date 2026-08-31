
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
public class _500C {

}

 */

class node implements Comparable<node>
{
	public int n;
	public int w;
	public int m;
	
	public int compareTo(node o) 
	{
		return (this.m - o.m);
	}
}

public class _500C {
	private static PrintWriter printWriter;

	public void solve() throws FileNotFoundException {
		InputStream inputStream = System.in;

		InputHelper inputHelper = new InputHelper(inputStream);

		PrintStream out = System.out;

		//actual solution

		int n = inputHelper.readInteger();
		int m = inputHelper.readInteger();
		
		int[] ma = new int[m];
		
		node[] nodes = new node[n];
		for(int i = 0; i < n; i++)
		{
			nodes[i] = new node();
			
			nodes[i].n = i + 1;
			nodes[i].w = inputHelper.readInteger();
			nodes[i].m = 10000;
		}
		
		for(int i = 0; i < m; i++)
		{
			int mv = inputHelper.readInteger();
			
			ma[i] = mv;
			
			if(nodes[mv - 1].m == 10000)
			{
				nodes[mv - 1].m = i;
			}
		}
		
		Arrays.sort(nodes);
		
		int lw = 0;
		for(int i = 0; i < m; i++)
		{
			int j;
			for(j = 0;; j++)
			{
				if(nodes[j].n != ma[i])
				{
					lw += nodes[j].w;
				}
				else
					break;
			}
			
			for(int k = 0; k < j; k++)
			{
				swap(nodes, k, j);
			}
		}
		
		System.out.println(lw);
		//end here

	}

	private void swap(node[] nodes, int k, int j) {
		node t = nodes[k];
		
		nodes[k] = nodes[j];
		nodes[j] = t;
	}

	public static void main(String[] args) throws FileNotFoundException {
		(new _500C()).solve();
	}

	class InputHelper {
		StringTokenizer tokenizer = null;
		private BufferedReader bufferedReader;

		public InputHelper(InputStream inputStream) {
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			bufferedReader = new BufferedReader(inputStreamReader, 16384);
		}

		public String read() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					String line = bufferedReader.readLine();
					if (line == null) {
						return null;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		public Integer readInteger() {
			return Integer.parseInt(read());
		}

		public Long readLong() {
			return Long.parseLong(read());
		}
	}
}