import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
 
public class Main {
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    public static int maxn = (int) (1e6 + 5);
    public static int[] p = new int[maxn];
    public static int[] ans = new int[maxn];
    public static int[] fa = new int[maxn];
    public static int findfa(int x) {
    	if(fa[x] != x) fa[x] = findfa(fa[x]);
    	return fa[x];
    }
    public static class node implements Comparable<node> {
    	int x, id, ty;
    	node(int _x, int _id, int _ty) {
    		x = _x;
    		id = _id;
    		ty = _ty;
    	}
		@Override
		public int compareTo(node rhs) {
			if(id == rhs.id) {
				if(ty == 1) return x - rhs.x;
				else return rhs.x - x;
			}
			return id - rhs.id;
		}
    	
    }
    public static node[] pos = new node[maxn];
    public static node[] val = new node[maxn];
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 1; i <= n; ++i) {
        	fa[i] = i;
        	p[i] = in.nextInt();
        }
        for(int i = 1; i <= m; ++i) {
        	int u = in.nextInt();
        	int v = in.nextInt();
        	int fu = findfa(u);
        	int fv = findfa(v);
        	if(fu == fv) continue;
        	fa[fu] = fv;
        }
        for(int i = 1; i <= n; ++i) {
        	int fi = findfa(i);
        	pos[i] = new node(i, fi, 1);
        	val[i] = new node(p[i], fi, 2);
        }
        Arrays.parallelSort(pos, 1, n + 1);
        Arrays.parallelSort(val, 1, n + 1);
        for(int i = 1; i <= n; ++i) {
        	ans[pos[i].x] = val[i].x;
        }
        StringBuffer res = new StringBuffer();
        for(int i = 1; i <= n; ++i) {
        	if(i > 1) out.print(" ");
        	out.print(ans[i]);
        }
        out.println(res);
        out.flush();
//   	 	Scanner in = new Scanner(System.in);
//    	in.close();
    }
}

/*


*/
		  	  		 	 	 	    	 	 		 					