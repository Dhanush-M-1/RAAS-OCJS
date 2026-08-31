import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;

/* Codeforces Round #351 (VK Cup 2016 Round 3, Div. 2 Edition) 
 *  Bear and Two Paths
 * @author : raghumdani
*/

public class Problem_673_D {
	public static final int testCases = 1;
	
	public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        for (int t = 1; t <= testCases; ++t) {
            Problem_673_D solver = new Problem_673_D ();
            solver.solve(t, in, out);
        }
        out.close();
    }

	int[] used;
	int[] next;
	
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();
        a--; b--; c--; d--;
        used = new int[n];
        next = new int[n];
        
        if(n == 4) {
            out.println(-1);
            return;
        }
        if(k < n + 1) {
            out.println(-1);
            return;
        }
        
        used[a] = used[b] = used[c] = used[d] = 1;
        int last = unused(n), x;
        int st = last;
        while((x = unused(n)) != -1) {
            next[last] = x;
            last = x;
        }
        
        out.print((a + 1) + " " + (c + 1));
        int cur = st;
        while(true) {
            out.print(" " + (cur + 1));
            if(cur == last) break;
            cur = next[cur];
        }
        out.println(" " + (d + 1) + " " + (b + 1));
        
        out.print((c + 1) + " " + (a + 1));
        
        cur = st;
        while(true) {
            out.print(" " + (cur + 1));
            if(cur == last) break;
            cur = next[cur];
        }
        
        out.println(" " + (b + 1) + " " + (d + 1));
        return;
    }

    private int unused(int n) {
        for(int i = 0; i < n; ++i) {
            if(used[i] == 0) {
                used[i] = 1;
                return i;
            }
        }
        return -1;
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

    }
}