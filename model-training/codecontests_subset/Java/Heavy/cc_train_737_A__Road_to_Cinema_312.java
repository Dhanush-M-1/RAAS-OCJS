import java.util.*;
import java.io.*;
public class D{
	public static void main(String[] args) throws Exception{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = sc.readLine();
		StringBuffer myBuff = new StringBuffer();
		int n = Integer.parseInt(str.split(" ")[0]);
		int k = Integer.parseInt(str.split(" ")[1]);
		int s = Integer.parseInt(str.split(" ")[2]);
		int t = Integer.parseInt(str.split(" ")[3]);
		
		int[] c = new int[n];
		int[] v = new int[n];
		for(int i = 0; i < n; i++){
			String[] strs = sc.readLine().split(" ");
			c[i] = Integer.parseInt(strs[0]);
			v[i] = Integer.parseInt(strs[1]);
		}
		int[] g_raw = new int[k + 1];
		String[] strs = sc.readLine().split(" ");	
		for(int i = 0; i < k; i++){
			g_raw[i] = Integer.parseInt(strs[i]);
		}
		g_raw[k] = s;
		Arrays.sort(g_raw);
		int[] g = new int[k + 1];
		for(int i = 0; i < k + 1; i++){
			if(i == 0)
				g[i] = g_raw[i];
			else
				g[i] = g_raw[i] - g_raw[i - 1];
		}
		Arrays.sort(g);

		long oil = bin_search(g, (long) (g[k]), (long) (2 * g[k]), t);
		// System.out.println(oil);
		if(valid_t(g, oil) > t){
			myBuff.append(-1);
		} else {
			int min_val = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++){
				if(v[i] >= oil){
					min_val = Math.min(min_val, c[i]);
				}
			}
			if(min_val == Integer.MAX_VALUE)
				min_val = -1;
			myBuff.append(min_val);
		}
		out.write(myBuff.toString());
		out.flush();
	}

	private static long bin_search(int[] g, long low, long high, int t){
		long mid = (low + high) / 2;
		int v = valid_t(g, mid);
		while(low < high){
			mid = (low + high) / 2;
			v = valid_t(g, mid);
			// System.out.println("mid, v, t: " + mid + ", " + v + ", " + t);
			if(v < t)
				high = mid;
			else if(v > t)
				low = mid + 1;
			else{
				return mid;
			}
		}
		return low;
	}

	private static int valid_t(int[] g, long oil){
		int t = 0;
		for(int i = 0; i < g.length; i++){
			int val = 0;
			if(oil >= 2 * g[i]){
				t += g[i];
			} else {
				t += (int) ((oil - g[i]) + (2 * g[i] - oil) * 2);
			}
		}
		return t;
	}
}