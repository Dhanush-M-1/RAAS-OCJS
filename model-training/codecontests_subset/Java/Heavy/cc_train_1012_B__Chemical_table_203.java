

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zouzhitao
 *
 */
public class Main {  
	public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in),65536));
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public final static int MAX_ARRAY_SIZE = 200000+10;
	public static List<Integer>[] G = new List[MAX_ARRAY_SIZE*2];
	public static int n,m,q;
	public static boolean[] vis = new boolean[MAX_ARRAY_SIZE*2];
	
	public static int component() {
		Arrays.fill(vis, 1,n+m+1,false);
		int ret =0;
		
		for(int i=1 ; i <=n+m ; ++i)
			if(!vis[i]){
				ret++;
				dfs(i);
			}
		
		return ret;
	}
	
	private static void dfs(int u) {
		vis[u] = true;
		for(int v : G[u]){
			if(!vis[v])dfs(v);
		}
	}
	public static String[] tokenPoll;
    public static void main(String[] args) {
    	n = Integer.parseInt(in.next());
    	m = Integer.parseInt(in.next());
    	q = Integer.parseInt(in.next());
    	for(int i=1 ; i<=n+m ; ++i)G[i] = new ArrayList<>();
    	while (q-->0) {
    		int x= Integer.parseInt(in.next());
    		int y = Integer.parseInt(in.next());
			y+=n;
			G[x].add(y);
			G[y].add(x);
		}
    	out.println(component()-1);
    	out.flush();
    }
    
}
