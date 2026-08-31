import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class D
{
     static StringBuilder sb = new StringBuilder();
     static ArrayList<HashSet<Integer>> g;
     static int[] depth;
     static boolean[] d;
     static int[] dc;
	 public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        if(n%2 == 0) System.out.println("NO");
        else {
            g = new ArrayList<>();
            for(int i=0; i<n; i++){
                g.add(new HashSet<>());
            }
            int root = 0;
            for(int i=0; i<n; i++){
                int v = fr.nextInt();
                if(v == 0) {
                    root = i;
                }else{
                    g.get(i).add(v-1);
                    g.get(v-1).add(i);
                }
            }
            depth = new int[n];
            d = new boolean[n];
            dc = new int[n];
            sb.append("YES\n");
            depth[root] = 1;
            dfs(root);
            System.out.print(sb);
        }
    }
    static void dfs(int u){
        for(int v : g.get(u)){
            if(depth[v] == 0) {
                depth[v] = depth[u]+1;
                dfs(v);
            }
        }
        if((g.get(u).size()-dc[u]) % 2 == 0) {
            for(int v : g.get(u)){
                if(depth[v] == depth[u] - 1 && !d[v]) dc[v]++;
            }
            destroy(u);
        }
    }
    static void destroy(int u){
        d[u] = true;
        sb.append((u+1) + "\n");
        for(int v : g.get(u)){
            if(depth[v] == depth[u] + 1 && !d[v]) destroy(v);
        }
    }
}

class FastReader{
	BufferedReader br;
	StringTokenizer st;

	FastReader(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next(){
		while(st==null || !st.hasMoreTokens()){
			try{
				st = new StringTokenizer(br.readLine());
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt(){
		return Integer.parseInt(next());
	}

	long nextLong(){
		return Long.parseLong(next());
	}

	double nextDouble(){
		return Double.parseDouble(next());
	}

	String nextLine(){
		String str = "";
		try{
			str = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return str;
	}
}
