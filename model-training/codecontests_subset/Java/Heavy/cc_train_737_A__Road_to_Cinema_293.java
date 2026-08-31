import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class a {

	static long t, lens[];
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int k = in.nextInt();
		long s = in.nextInt();
		t = in.nextLong();
		
		long[] cs = new long[n];
		long[] vs = new long[n];
		for(int i = 0; i < n; i++) {
			cs[i] = in.nextLong();
			vs[i] = in.nextLong();
		}
		
		ArrayList<Long> stations = new ArrayList<>();
		for(int i = 0; i < k; i++)
			stations.add(in.nextLong());
		Collections.sort(stations);
		lens = new long[k + 1];
		long cur = 0;
		int curI = 0;
		for(long a : stations) {
			lens[curI++] = a - cur;
			cur = a;
		}
		lens[curI] = s - cur;
		//System.out.println(Arrays.toString(lens));
		long minFuel = bs(0, s * 4);
		//System.out.println(minFuel);
		long ans = -1;
		for(int i = 0; i < n; i++) {
			if(vs[i] >= minFuel) {
				if(cs[i] < ans || ans == -1)
					ans = cs[i];
			}
		}
		out.println(ans);
		out.close();
	}
	
	static long bs(long min, long max) {
		if(min + 1 >= max) {
			if(canDo(min)) return min;
			if(canDo(max)) return max;
			return Long.MAX_VALUE;
		}
		long mid = (min + max) / 2;
		if(canDo(mid))
			return bs(min, mid);
		return bs(mid, max);
	}
	
	static boolean canDo(long fuel) {
		long time = 0;
		for(long len : lens) {
			if(fuel < len) {
				return false;
			}
			time += getTime(len, fuel);
		}
		//System.out.println(fuel + "  " + time);
		return time <= t;
	}
	
	static long getMinFuel(int len) {
		return len;
	}
	static long getTime(long len, long fuel) {
		long x = Math.min(fuel - len, len);
		long y = len - x;
		return y * 2 + x;
	}
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    public int[] nextIntArray(int n) throws IOException {
	    	int[] arr = new int[n];
	    	for(int i = 0; i < n; i++)
	    		arr[i] = nextInt();
	    	return arr;
	    }
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public long[] nextLongArray(int n) throws IOException {
	    	long[] arr = new long[n];
	    	for(int i = 0; i < n; i++)
	    		arr[i] = nextLong();
	    	return arr;
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	    public double[] nextDoubleArray(int n) throws IOException {
	    	double[] arr = new double[n];
	    	for(int i = 0; i < n; i++)
	    		arr[i] = nextDouble();
	    	return arr;
	    }
	    public int[] nextOffsetIntArray(int n) throws IOException {
	    	int[] arr = new int[n];
	    	for(int i = 0; i < n; i++)
	    		arr[i] = nextInt() - 1;
	    	return arr;
	    }
	}
}
