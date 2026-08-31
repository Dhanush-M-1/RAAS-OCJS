import java.io.*;
import java.util.*;
public class Sol{
	static class specInt {
		int restore[];
		int val;
		public specInt(int val) {
			this.val = val;
			restore = new int[n+1];
		}
	}
	public static int mxN = 76;
	public static specInt dp[][] = new specInt[mxN][mxN];
	public static int arr[][];
	public static int n, k;
	public static int restore[];
	public static void main(String[] args) throws IOException{
		FastIO sc = new FastIO(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			k = sc.nextInt();
			arr = new int[n+1][3];
			restore = new int[n+1];
			for(int i=0; i<mxN; ++i) {
				for(int j=0; j<mxN; ++j) {
					dp[i][j] = new specInt(Integer.MIN_VALUE);
				}
			}
			for(int i=1; i<=n; ++i) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = i;
			}
			ColumnSort(arr, 1);
			dp[0][0].val = 0;
			for(int i=1; i<=n; ++i) {
				for(int j=0; j<=k; ++j) {
					//if(dp[i-1][j].val!=Integer.MIN_VALUE) {
						if(arr[i][1]*(k-1)+dp[i-1][j].val>dp[i][j].val) {
							dp[i][j].val = arr[i][1]*(k-1)+dp[i-1][j].val;
							for(int b=1; b<=n; ++b) {
								dp[i][j].restore[b] = dp[i-1][j].restore[b];
							}
							dp[i][j].restore[i] = 0;
						}
						if(j<k&&arr[i][0] + arr[i][1]*j+dp[i-1][j].val>dp[i][j+1].val) {
							dp[i][j+1].val = arr[i][0] + arr[i][1]*j+dp[i-1][j].val;
							for(int b=1; b<=n; ++b) {
								dp[i][j+1].restore[b] = dp[i-1][j].restore[b];
							}
							dp[i][j+1].restore[i] = 1;
						}
					//}
				}
			}
			int idx = 0;
			int num = 0;
			for(int i=1; i<=n; ++i) {
				if(dp[n][k].restore[i]==1) num++;
				else num+=2;
			}
			out.println(num);
			for(int i=1; i<=n; ++i) {
				if(idx<k-1&&dp[n][k].restore[i]==1) {
					out.print(arr[i][2] + " ");
					idx++;
				}
			}
			for(int i=1; i<=n; ++i) {
				if(dp[n][k].restore[i]==0) {
					out.print(arr[i][2] + " " + (-arr[i][2]) + " ");
				}
			}
			for(int i=n; i>=0; --i) {
				if(dp[n][k].restore[i]==1) {
					out.println(arr[i][2]);
					break;
				}
			}
			out.println();
		}

		out.close();
	}
    public static void ColumnSort(int arr[][], int col) { 
        Arrays.sort(arr, new Comparator<int[]>() { 
            @Override 
          public int compare(int[] entry1,  
                             int[] entry2) { 
            	Integer a = entry1[col];
            	Integer b = entry2[col];
            	return a.compareTo(b);
          } 
        }); 
    }
	static class FastIO {
		 
		// Is your Fast I/O being bad?
 
		InputStream dis;
		byte[] buffer = new byte[1 << 17];
		int pointer = 0;
 
		public FastIO(String fileName) throws IOException {
			dis = new FileInputStream(fileName);
		}
 
		public FastIO(InputStream is) throws IOException {
			dis = is;
		}
 
		int nextInt() throws IOException {
			int ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		long nextLong() throws IOException {
			long ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		byte nextByte() throws IOException {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}
 
		String next() throws IOException {
			StringBuffer ret = new StringBuffer();
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}
 
			return ret.toString();
		}
 
	}
}