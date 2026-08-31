/**
 *
 * @author sarthak
 */

import java.util.*;
import java.math.*;
import java.io.*;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;



public class rduRnd14_D {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    static class P implements Comparable{

        private int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return (x * 31) ^ y;
        }

        public boolean equals(Object o) {
            if (o instanceof P) {
                P other = (P) o;
                return (x == other.x && y == other.y);
            }
            return false;
        }
        public int compareTo(Object obj) {
		P l = (P) obj;
		if (this.x == l.x){
			if (this.y == l.y) return 0;
			return (this.y < l.y)? -1: 1;
		}
		return (this.x < l.x)? -1: 1;
	}
    }
    static ArrayList<Integer> G[];
    static int[] vis;
    static ArrayList<Integer>al;
    public static void dfs(int v){
        vis[v]=1;
        al.add(v);
        for(int ad:G[v])
            if(vis[ad]==0)
                dfs(ad);
    }

    public static void main(String[] args){
         
    FastScanner s = new FastScanner(System.in);
    StringBuilder op=new StringBuilder();
    
    int n=s.nextInt();
    int m=s.nextInt();
    int[] a=new int[n+1];
    ArrayList<Integer>bl=new ArrayList<>();
    for(int i=1;i<=n;i++)a[i]=s.nextInt();
    G=new ArrayList[n+1];
    for(int i=1;i<=n;i++)G[i]=new ArrayList<>();
    for(int i=0;i<m;i++){
        int u=s.nextInt();
        int v=s.nextInt();
        G[u].add(v);
        G[v].add(u);
        bl.add(u);bl.add(v);
    }
    vis=new int[n+1];
    
    for(int i:bl)
        if(vis[i]==0){
            al=new ArrayList<>();
            dfs(i);
            ArrayList<Integer> b=new ArrayList<>();
            for(int j:al)b.add(a[j]);
            Collections.sort(al);Collections.sort(b);
            for(int j=al.size()-1;j>=0;j--)
                a[al.get(j)]=b.get(al.size()-1-j);
            
            
        }
    
    for(int i=1;i<=n;i++)
        op.append(a[i]+" ");
    System.out.println(op);
    
    }


}
