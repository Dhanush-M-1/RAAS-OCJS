import java.lang.*;
import java.io.*;
import java.util.*;


public class Thieves {
	
	public static void main(String[] args) throws java.lang.Exception {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
}

class TaskA {
	String s;
	int len;
	
	public void solve(InputReader in, PrintWriter out) {
		len = in.nextInt();
		s = in.next();
		
		for (int i=1; i<=len; ++i) {
			if (judge(i)) {
				out.println("yes");
				return ;
			}
		}
		out.println("no");
	}
	
	public boolean judge(int l) {
		int i, j, k;
		boolean flag;
		
		for (i=0; i<len; ++i) {
			flag = true;
			for (k=0,j=i; k<5; ++k,j+=l) {
				if (j >= len) {
					flag = false;
					break;
				}
				// System.out.print(j + " ");
				if (s.charAt(j) == '.') {
					flag = false;
					break;
				}
			}
			// System.out.println();
			if (flag) {
				return true;
			}
		}
		
		return false;
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
		while (tokenizer==null || !tokenizer.hasMoreTokens()) {
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
