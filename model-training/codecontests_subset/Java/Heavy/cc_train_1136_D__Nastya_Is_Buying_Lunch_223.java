import java.io.*;
import java.util.*;
 
public class p1136d {

	public static void main(String[] args)throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[n];
		for(int t = 0; t < n; t++)
			arr[t]=in.nextInt()-1;
		HashSet<Integer> sets[] = new HashSet[n];
		for(int i=0;i<n;i++)
			sets[i]=new HashSet<Integer>();
		for(int i=0;i<m;i++)
		{
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			sets[v].add(u);
		}
		int ans = 0;
		HashSet<Integer> set = sets[arr[n-1]];
		for(int i=n-2;i>=0;i--)
			if(set.contains(arr[i]))
				ans++;
			else
				set.retainAll(sets[arr[i]]);
		out.println(ans);
        out.close();
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