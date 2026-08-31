import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		cf500TaskC solver = new cf500TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class cf500TaskC
{
	public void solve(int test, InputReader in, PrintWriter out){
		int n = in.nextInt();
		int m = in.nextInt();
		int[] wt = new int[n];
		int[] order = new int[m];
		
		for(int i = 0; i<n; i++)
			wt[i] = in.nextInt();
		for(int i = 0; i<m; i++)
			order[i] = in.nextInt();
		boolean[] hash = new boolean[1234];
		
		int res = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<m; i++){
			if (hash[order[i]] == false){
				hash[order[i]] = true;
				list.add(order[i]);
			}
		}
		
		for(int i = 0; i<m; i++){
			int sum = 0, j = 0;
			for(; list.get(j) != order[i]; j++){
				sum += wt[list.get(j)-1];
			}
			res += sum;
			for(int k = j; k>0; k--){
				int c = list.get(k);
				list.set(k, list.get(k-1));
				list.set(k-1, c);
			}
		}
		out.println(res);
	}
}
		
class InputReader {
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
