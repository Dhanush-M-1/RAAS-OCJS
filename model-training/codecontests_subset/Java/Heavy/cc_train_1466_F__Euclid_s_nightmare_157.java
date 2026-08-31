import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class f {
	public static void main(String[] args) {
		FastScanner scan=new FastScanner();
		PrintWriter out=new PrintWriter(System.out);
		
		/*
-		if you have a vector with only cell k equal to 1, and a vector with only cell j equal to 1
		and then another vector with j and k equal to 1
		you won't ever want that since there's nothing to gain from it
		so accept only the first two of those that appear.
		
-		if you have 3 vectors with zeros at (a,b), (b,c), and (a,c)
		that's also bad because	two automatically cover the third
		so again accept only the first two of those that appear.
		
		in fact, cycles in general are a bad idea
		so let's check for those.		
		*/
		int n=scan.nextInt(), m=scan.nextInt();
		
		DSU d=new DSU(m+1);
		
		ArrayDeque<Integer> q=new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			int x=scan.nextInt();
			int u=0, v=0;
			u=scan.nextInt();
			if(x==2) v=scan.nextInt();
			
			if(!d.unite(u,v)) {
				//they're not united yet, we have smth to gain by having this vector in the set
				q.offer(i+1);
			}
		}
		out.println(pow(2,q.size())+" "+q.size());
		while(!q.isEmpty()) out.print(q.poll()+" ");
		out.println();
		
		out.close();
	}
	static class DSU {
        int n;
        int[] parent, size;

        public DSU(int v) {
            n = v;
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findRoot(int curr) {
            if(curr == parent[curr]) return curr;
            return parent[curr] = findRoot(parent[curr]);
        }

        public boolean unite(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if(rootA == rootB) return true;
            if(size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
            else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            return false;
        }

    }
	public static long pow(long b, long e) {
		if(e==0) return 1L;
		if(e==1) return b;
		
		if(e%2==0) {
			long temp=pow(b,e/2)%MOD;
			return (temp*temp)%MOD;
		}
		return (b*pow(b,e-1)%MOD)%MOD;
	}
	static final int MOD=1_000_000_007;
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}

		public int nextInt() {return Integer.parseInt(next());}

		public long nextLong() {return Long.parseLong(next());}

		public double nextDouble() {return Double.parseDouble(next());}

		public String nextLine() {
			String line = "";
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}
	}
}