import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class C {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
	public void solve() throws IOException {				
		int N = nextInt();
        int M = nextInt();
		int[] W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = nextInt();
        }
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = nextInt() - 1;
        }

        boolean[] appeared = new boolean[N];
        ArrayList<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            if (appeared[B[i]]) continue;
            appeared[B[i]] = true;
            order.add(B[i]);
        }

        Stack<Integer> books = new Stack<Integer>();
        for (int i = order.size()-1; i >= 0; i--) {
            books.push(order.get(i));
        }

        long ans = 0;
        Stack<Integer> lifted = new Stack<Integer>();
        for (int i = 0; i < M; i++) {

//            out.print(i + ": ");
//            for (int b: books) {
//                out.print((b+1) + " ");
//            }
//            out.println();


            while (books.peek() != B[i]) {
                int b = books.pop();
                ans += W[b];
                lifted.push(b);
            }
            books.pop();
            while (!lifted.isEmpty()) {
                int b = lifted.pop();
                books.push(b);
            }
            books.push(B[i]);

        }
        out.println(ans);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new C().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
