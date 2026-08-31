import java.io.*;
import java.util.*;
public class Sol{
	public static double dpmax[] = new double[200001];
	public static double dpmin[] = new double[200001];
	public static double min;
	public static double max;
	public static int arr[];
	public static int n;
    public static void main(String[] args) throws IOException{
    	FastScanner sc = new FastScanner();
    	n = sc.nextInt();
    	arr = new int[n];
    	for(int i=0; i<n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	double err = 1e-11;
    	double r = 1e6;
    	double l = -1e6;
    	while(r-l>err) {
    		double m1 = l + (r-l)/3;
    		double m2 = r - (r-l)/3;
    		double f1 = func(m1);
    		double f2 = func(m2);
        	if(f1<f2) {
        		r = m2;
        	}else {
        		l = m1;
        	}
    	}
    	System.out.println(func(l));
    	
    }
    public static double func(double delt) {
    	dpmax[0] = arr[0]-delt;
    	dpmin[0] = arr[0]-delt;
    	max = dpmax[0];
    	min = dpmin[0];
    	for(int i=1; i<n; i++) {
    		dpmax[i] = arr[i]-delt + Math.max(0, dpmax[i-1]);
    		dpmin[i] = arr[i]-delt + Math.min(0, dpmin[i-1]);
    		min = Math.min(dpmin[i], min);
    		max = Math.max(max, dpmax[i]);
    	}
    	return Math.max(Math.abs(min), Math.abs(max));
    }
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
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
