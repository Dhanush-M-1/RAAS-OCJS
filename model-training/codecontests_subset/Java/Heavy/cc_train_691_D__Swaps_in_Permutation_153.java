import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class ABC {

	static int N, E; 
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] nums;
	static ArrayList<Integer> CC;
	static Scanner sc;
	public static void main(String[] args) throws IOException{
		
		sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		construct();
		for(int i = 0; i < N; i++)
			if(!visited[i])
			{
				CC = new ArrayList<>();
				dfs(i);
				
				Collections.shuffle(CC);
				Collections.sort(CC);
				
				ArrayList<Integer> CCV = new ArrayList<>();
				for(int j : CC)
					CCV.add(nums[j]);
				
				Collections.shuffle(CCV);
				Collections.sort(CCV);
				
				for(int j = 0; j < CC.size(); j++)
					nums[CC.get(j)] = CCV.get(CC.size()-j-1);
			}
		
		for(int i : nums)
		{
			out.print(i);
			out.print(" ");
		}
		out.flush();
	}
	
	static void construct()throws IOException
	{
		N = sc.nextInt(); E = sc.nextInt();
		nums = new int[N];
		for(int i = 0; i < N; i++)
			nums[i] = sc.nextInt();
		
		adjList = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++)
		{
			int from = sc.nextInt()-1, to = sc.nextInt()-1;
			adjList[from].add(to);
			adjList[to].add(from);
		}
	}
	
	static void dfs(int u)					
	{
		visited[u] = true;
		CC.add(u);
		for(int v: adjList[u])
			if(!visited[v])
				dfs(v);
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {

			br = new BufferedReader(new InputStreamReader(s));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
	}
		
		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}