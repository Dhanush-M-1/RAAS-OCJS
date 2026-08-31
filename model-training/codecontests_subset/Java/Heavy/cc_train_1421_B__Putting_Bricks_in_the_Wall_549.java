import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;

public class B_1421 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			String[] matrix = new String[n];

			for (int j = 0; j < n; j++) {
				matrix[j] = br.readLine();
			}

				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(0);
				}
			
				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(1);
					System.out.println((n-1)+" "+(n));
				}
				
				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(1);
					System.out.println((n)+" "+(n-1));
				}
				
				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(2);
					System.out.println((n-1)+" "+(n));
					System.out.println((n)+" "+(n-1));
				}
				


				
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(2);
					System.out.println((n-1)+" "+(n));
					System.out.println((n)+" "+(n-1));
				}
			
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(1);
					System.out.println((n)+" "+(n-1));
				}
				
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(1);
					System.out.println((n-1)+" "+(n));
				}
				
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(0);
				}
				
				
				
				
				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(1);
					System.out.println(2+" "+1);
				}
				
				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(1);
					System.out.println(1+" "+2);
				}
				
				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(2);
					System.out.println(1+" "+2);
					System.out.println(n+" "+(n-1));
				}
				
				if(matrix[0].charAt(1) == '0' && matrix[1].charAt(0) == '1' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(2);
					System.out.println(1+" "+2);
					System.out.println((n-1)+" "+(n));
				}
				
				
				
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(1);
					System.out.println(1+" "+2);
				}
				
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(1);
					System.out.println(2+" "+1);
				}
				
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '0' && matrix[n - 1].charAt(n - 2) == '1') {
					System.out.println(2);
					System.out.println(2+" "+1);
					System.out.println(n+" "+(n-1));
				}
				
				if(matrix[0].charAt(1) == '1' && matrix[1].charAt(0) == '0' && matrix[n - 2].charAt(n - 1) == '1' && matrix[n - 1].charAt(n - 2) == '0') {
					System.out.println(2);
					System.out.println(2+" "+1);
					System.out.println((n-1)+" "+(n));
				}

		}
	}

	static int read() throws IOException {
		return br.read();
	}

	static int nextInt() throws IOException {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	static long nextLong() throws NumberFormatException, IOException {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	static int[] readIntegerArray(int n) throws IOException {
		int[] arr = new int[n];

		String input;

		while ((input = br.readLine()) != null) {

			if (input != null && !input.equals("")) {
				break;
			}
		}

		String[] strArr = input.split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}

		return arr;
	}

	static long[] readlongArray(int n) throws IOException {
		long[] arr = new long[n];

		String input;

		while ((input = br.readLine()) != null) {

			if (input != null && !input.equals("")) {
				break;
			}
		}
		String[] strArr = input.split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(strArr[i]);
		}

		return arr;
	}

	static boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
}
