import java.io.*;
import java.util.*;

public class cf1382_Div2_A {
	
	public static void main(String args[]) {
		FastScanner in = new FastScanner();
		int t = in.nextInt();
		for ( ; t > 0; t--) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			for (int i = 0; i < n; i++) a[i] = in.nextInt();
			for (int i = 0; i < m; i++) b[i] = in.nextInt();
			boolean flag = false;
			for (int i = 0; i < n && !flag; i++) {
				for (int j = 0; j < m && !flag; j++) {
					if (a[i] == b[j]) {
						System.out.println("YES");
						System.out.println(1 + " " + a[i]);
						flag = true;
					}
				}
			}
			if (!flag) System.out.println("NO");
		}
	}
	    
    public static void shuffle(int[] arr) {
    	Random rgen = new Random();
    	
    	for (int i = 0; i < arr.length; i++) {
    		int rPos = rgen.nextInt(arr.length);
    		int temp = arr[i];
    		arr[i] = arr[rPos];
    		arr[rPos]=temp;
    	}
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
