import java.util.*;
import java.math.*;

// **** D. Compression ****

public class D {
	static char [] in = new char [1000000];
	static int [] map = new int [256];
	static boolean [][] g;
	public static void main (String [] arg) throws Throwable {
		int n = nextInt();
		g = new boolean [n][n];
		
		for (char c = '0' ;c<='9'; ++c) map[c] = c - '0';
		for (char c = 'A' ;c<='F'; ++c) map[c] = c - 'A' + 10;
		for (int i = 0; i<n; ++i) {
			char [] in2 = next();
			for (int j = 0; j<n/4; ++j) {
				for (int k = 0; k<4; ++k) {
					g[i][k+j*4] = ((map[in2[j]] >> (3-k)) & 1) != 0;
				}
			}
		}
		boolean [][] dp_row = new boolean [n][n];
		boolean [][] dp_col = new boolean [n][n];
		for (int i = 0; i<n-1; ++i) dp_row[i][i+1] = rowEqual(i,i+1);
		for (int i = 0; i<n-1; ++i) dp_col[i][i+1] = colEqual(i,i+1);
		int MAX = n;
		for (int i = 0, i2 = 0; i<n; i=i2) {
			for (i2 = i+1; i2<n; ++i2) if (!dp_row[i2-1][i2]) break;
			MAX = gcd(MAX, i2-i);
			//System.err.println("Break at row " + (i2) + " GCD Is now " + MAX);
		}
		for (int i = 0, i2 = 0; i<n; i=i2) {
			for (i2 = i+1; i2<n; ++i2) if (!dp_col[i2-1][i2]) break;
			MAX = gcd(MAX, i2-i);
			//System.err.println("Break at col " + (i2-1) + " 0-0 " + MAX);
		}
		System.out.println(MAX);
				
	}
	public static boolean rowEqual(int i, int j) {
		for (int k = 0; k<g[0].length; ++k) if (g[i][k] != g[j][k]) return false;
		return true;
	}
	public static boolean colEqual(int i, int j) {
		for (int k = 0; k<g.length; ++k) if (g[k][i] != g[k][j]) return false;
		return true;
	}
	

	
	
	
	
	
	
	
	
	
	
	public static int gcd(int a, int b) {while (b != 0) {int tmp = b;b = (a % b);a = tmp;}return a;}
	
	/************** FAST IO CODE FOLLOWS *****************/
	public static long nextLong() throws Throwable {
		long i = System.in.read();boolean neg = false;while (i < 45) i = System.in.read();if (i == 45) {neg=true;i=48;}i = i - 48;
		int j = System.in.read();while (j > 32) {i*=10;i+=j-48;j = System.in.read();}return (neg) ? -i : i;
	}
	public static int nextInt() throws Throwable {return (int)nextLong();}
	public static char [] next() throws Throwable {
		int i = 0; while (i < 42 && i != -1) i = System.in.read(); int cptr = 0; while (i >= 42) { in[cptr++] = (char)i; i = System.in.read();}
		return in;
	}
}

/* Full Problem Text:
  
You are given a binary matrix A of size n \times n.
Let's denote an x-compression of the given matrix as a matrix B of size \frac{n}{x} \times \frac{n}{x} such that for every i \in [1, n], j \in [1, n] the condition A[i][j] = B[\lceil \frac{i}{x} \rceil][\lceil \frac{j}{x} \rceil] is met.
Obviously, x-compression is possible only if x divides n, but this condition is not enough.
For example, the following matrix of size 2 \times 2 does not have any 2-compression:
 01   10 
For the given matrix A, find maximum x such that an x-compression of this matrix is possible.
Note that the input is given in compressed form.
But even though it is compressed, you'd better use fast input.

 */