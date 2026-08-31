
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, sc, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
        	int n=sc.nextInt();
            ArrayList<Integer>[] map=new ArrayList[n+1];
            for(int i=1;i<=n;i++)
            	map[i]=new ArrayList<Integer>();
            
            for(int i=0;i<n-1;i++) {
            	int u=sc.nextInt();
            	int v=sc.nextInt();
            	map[u].add(v);
            	map[v].add(u);
            }
       
            boolean[] jud=new boolean[n+1];
            for(int i=1;i<=n;i++) {
            	if(map[i].size()==1)
            		jud[i]=true;
            }
            for(int i=1;i<=n;i++) {
            	if(!jud[i]&&map[i].size()==2) {
            		out.println("NO");
            		return ;
            	}
            }
            out.println("YES");
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
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
}
