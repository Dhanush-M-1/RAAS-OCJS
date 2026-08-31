import java.util.*;
import java.io.*;

public class A {
	static FastReader f = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t = f.nextInt();
		while(t-- > 0) {
			solve();
		}
		out.close();
	}


	static void solve() {
		int n = f.nextInt();

		int[][] arr = new int[n][n];

		for(int i=0;i<n;i++) {
			String s = f.next();
			for(int j=0;j<n;j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int oneF = 0;
		if(arr[0][1] == 1) {
			oneF++;
		}
		
		if(arr[1][0] == 1) {
			oneF++;
		}
		
		int oneS = 0;
		if(arr[n-1][n-2] == 1) {
			oneS++;
		}
		
		if(arr[n-2][n-1] == 1) {
			oneS++;
		}

		ArrayList<int[]> ch = new ArrayList<>();
		if(oneS != 1 && oneS == oneF) {
			//all 0 or 1
			ch.add(new int[] {1,2});
			ch.add(new int[] {2,1});
		} else if(Math.abs(oneS-oneF) == 1) {
			int loc = oneF + oneS;

			if(loc == 3) {
				if(arr[0][1] == 0) {
					ch.add(new int[] {1,2});
				}
				
				if(arr[1][0] == 0) {
					ch.add(new int[] {2,1});
				}
				
				if(arr[n-1][n-2] == 0) {
					ch.add(new int[] {n,n-1});
				}
				
				if(arr[n-2][n-1] == 0) {
					ch.add(new int[] {n-1,n});
				}
			} else {
				if(arr[0][1] == 1) {
					ch.add(new int[] {1,2});
				}
				
				if(arr[1][0] == 1) {
					ch.add(new int[] {2,1});
				}
				
				if(arr[n-1][n-2] == 1) {
					ch.add(new int[] {n,n-1});
				}
				
				if(arr[n-2][n-1] == 1) {
					ch.add(new int[] {n-1,n});
				}
			}
		} else if(oneS == 1 && oneS == oneF) {
			if(arr[0][1] == 1 && arr[1][0] == 0 && arr[n-1][n-2] == 0 && arr[n-2][n-1] == 1) {
				ch.add(new int[] {1,2});
				ch.add(new int[] {n,n-1});
			} else if(arr[0][1] == 0 && arr[1][0] == 1 && arr[n-1][n-2] == 1 && arr[n-2][n-1] == 0) {
				ch.add(new int[] {2,1});
				ch.add(new int[] {n-1,n});
			} else if(arr[0][1] == 1 && arr[1][0] == 0 && arr[n-1][n-2] ==0 && arr[n-2][n-1] == 0) {
				ch.add(new int[] {1,2});
				ch.add(new int[] {n-1,n});
			} else {
				ch.add(new int[] {2,1});
				ch.add(new int[] {n,n-1});
			}
			
			
		}

		out.println(ch.size());

		for(int[] i : ch) {
			out.println(i[1]+" "+i[0]);
		}


	}







	static class FastReader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
			return st.nextToken();
		}

		String nextLine() {
			String s = "";
			try {
				s = br.readLine();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}

			return s;
		}

		int  nextInt() {
			return Integer.parseInt(next());
		}

		long  nextLong() {
			return Long.parseLong(next());
		}
	}
}