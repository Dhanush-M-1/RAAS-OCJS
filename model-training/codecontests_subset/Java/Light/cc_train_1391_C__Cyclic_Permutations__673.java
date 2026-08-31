

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author b
 *
 */
public class C {
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner();
			solve(scanner);
	}
	
	static double mod = Math.pow(10, 9) + 7;
	
	private static void solve(Scanner scanner) {
		
		
		int n = scanner.nextInt();
		long n1 = n;
		long res = 1;
		long ill = 1;
		while (n1 > 1) {
			res = (long) ((res * n1) % mod);
			ill = (long) ((ill * 2) % mod);
			n1--;
		}
		
		System.out.println((long) ((res - ill + mod) % mod));
	}

	// Props to SecondThread
	static class Scanner {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer=new StringTokenizer("");
		
		String next() {
			while (!tokenizer.hasMoreTokens()) {
				try {
					tokenizer=new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] nextIntArr(int numberOfElements) {
			int[] values=new int[numberOfElements];
			for (int i=0; i<numberOfElements; i++) values[i]=nextInt();
			return values;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
