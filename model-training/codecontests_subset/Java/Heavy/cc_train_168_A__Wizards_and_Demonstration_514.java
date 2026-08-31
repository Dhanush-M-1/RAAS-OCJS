

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}
}

class Task {
	void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		n = n * y;
		if (n % 100 == 0) n /= 100;
		else n = n / 100 + 1;
		if (n <= x) 
			out.print(0);
		else 
			out.print(n - x);
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
    
    public int[] nextArray(int n) {
    	int answer[] = new int[n];
    	for (int i = 0; i < n; ++i) {
    		answer[i] = nextInt();
    	}
    	return answer;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    public StringBuilder nextStringBuilder() {
    	StringBuilder answer = new StringBuilder();
    	answer.append(next());
    	return answer;
    }
}
