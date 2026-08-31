import java.awt.Point;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	//////
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	//////
	public static long modularExponentiation(long x, long n, long M) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x) % M;
			x = (x * x) % M;
			n = n / 2;
		}
		return result;
	}

	public static long modularExponentiation1(long x, long n) {
		long result = 1;
		while (n > 0) {
			if (n % 2 == 1)
				result = (result * x);
			x = (x * x);
			n = n / 2;
		}
		return result;
	}

	/////

	static public int fun(int num) {
		int prod = 1;
		while (num > 0) {
			if (num % 10 != 0) {
				prod = prod * (num % 10);
			}
			num = num / 10;
		}
		return prod;
	}

	public static boolean dfs(int x, int find, boolean[] visited, int[][] matrix) {

		boolean ans = false;
		if (x == find) {
			ans = true;
			return true;
		}
		for (int i = 0; i < 26; i++) {
			if (visited[i] == false && matrix[x][i] == 1) {
				visited[i] = true;
				ans = ans || dfs(i, find, visited, matrix);
			}
		}

		return ans;
	}

	static int lis(int arr[], int n, int k, int b) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] >= k * arr[j] + b && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

	public static void main(String[] args) throws IOException {

		FastReader scan = new FastReader();
		PrintWriter pw = new PrintWriter(System.out);

		int N=scan.nextInt();
		int[] A=new int[N];
		int[] H=new int[N];
		for(int i=0;i<N;i++){
			A[i]=scan.nextInt();
			H[i]=scan.nextInt();
		}
		
		int count=2;
		
		for(int i=1;i<N-1;i++){
			if(A[i]-A[i-1]>H[i]){
				count++;
			}else if(A[i+1]-A[i]>H[i]){
				count++;
				A[i]=A[i]+H[i];
			}
		}
		
		if(N==1){
			System.out.println("1");
			return;
		}
		System.out.println(count);
				
	}
}