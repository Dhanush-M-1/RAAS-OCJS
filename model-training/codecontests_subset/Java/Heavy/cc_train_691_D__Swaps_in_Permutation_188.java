//package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class C {
    static ArrayList<Integer> adjList [];
    static boolean [] vis;
    static ArrayList<Integer> ind;
    public static void dfs(int u){
	vis[u] = true;
	ind.add(u); 
	for(int v: adjList[u])
	    if(!vis[v])
		dfs(v);
    }
    public static void main(String[] args) throws Exception
    {
	Scanner bf = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = bf.nextInt(), m = bf.nextInt();
	int [] tmp = new int[n];
	adjList = new ArrayList[n];
	vis = new boolean[n];
	for (int i = 0; i < adjList.length; i++)
	{
	    adjList[i] = new ArrayList<Integer>();
	}
	for (int i = 0; i < tmp.length; i++)
	{
	    tmp[i] = bf.nextInt();
	}
	for (int i = 0; i < m; i++)
	{
	    int u = bf.nextInt()-1, v = bf.nextInt()-1;
	    adjList[u].add(v); adjList[v].add(u);
	}
	for (int i = 0; i < n; i++)
	{
	    if(!vis[i]){
		ind = new ArrayList<Integer>();
		dfs(i);
		Integer [] val = new Integer[ind.size()];
		int j = 0;
		Collections.sort(ind);
		for(Iterator<Integer> it = ind.iterator();it.hasNext();){
		    val[j++] = tmp[it.next()];
		}
		Arrays.sort(val);
		j = ind.size()-1;
		for(Iterator<Integer> it = ind.iterator();it.hasNext();){
		    tmp[it.next()] = val[j--];
		}
	    }
	}
	for (int i = 0; i < tmp.length; i++)
	{
	    out.print(tmp[i] + " ");
	}
	out.flush();
	out.close();
    }
    static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s)
	{
	    br = new BufferedReader(new InputStreamReader(s));
	}

	public Scanner(FileReader fileReader)
	{
	    br = new BufferedReader(fileReader);
	}

	public String next() throws IOException
	{
	    while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine());
	    return st.nextToken();
	}

	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}

	public String nextLine() throws IOException
	{
	    return br.readLine();
	}

	public boolean ready() throws IOException
	{
	    return br.ready();
	}
    }
}
