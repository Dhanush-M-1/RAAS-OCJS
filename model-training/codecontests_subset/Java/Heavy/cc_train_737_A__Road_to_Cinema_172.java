import java.util.*;
import java.io.*;

public class codeforces729C {
	public static boolean checkIfPossible(int[] distance,int k,int t,int fuel) {
		int time = 0;
		for(int i=0;i<=k;i++) {
			if(distance[i]>fuel) {
				return false;
			} else if(fuel>=2*distance[i]){
				time+=distance[i];
			} else {
				time+=(3*distance[i]-fuel);
			}
		}
		return time<=t;
	}
	
	public static int findingMinimumTime(int left,int right,int k,int t,int[] distance) {
		while(left+1<right) {
			int mid = (left+right)/2;
			
			if(checkIfPossible(distance,k,t,mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}
	
	public static void main(String[] args) throws Exception{
		//InputReader in = new InputReader(new File("C:/Users/RED-DRAGON/workspace/input.txt"));
		InputReader in = new InputReader(System.in);
		//PrintWriter out = new PrintWriter(new File("C:/Users/RED-DRAGON/workspace/output.txt"));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = in.nextInt();
		int k = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		
		int[] c = new int[n+1];
		int[] v = new int[n+1];
		
		int vmax = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			c[i] = in.nextInt();
			v[i] = in.nextInt();
			vmax = Math.max(vmax, v[i]);
		}
		
		int[] g = new int[k];
		
		for(int i=0;i<k;i++) {
			g[i] = in.nextInt();
		}
		
		Arrays.sort(g);
		
		int[] distance = new int[k+1];
		distance[0] = g[0];
		for(int i=1;i<k;i++) {
			distance[i] = g[i] - g[i-1];
		}
		
		distance[k] = s-g[k-1];
		
		//out.println(checkIfPossible(distance,k,t,vmax));
		
		if(!checkIfPossible(distance,k,t,vmax)) {
			out.println(-1);
		} else {
			int minimumTime = findingMinimumTime(0,vmax,k,t,distance);
			
			int rslt = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				if(v[i]>=minimumTime) {
					rslt = Math.min(rslt, c[i]);
				}
			}
			out.println(rslt);
		}
		
		out.close();
	}
	
	public static void debug(Object...args) {
        System.out.println(Arrays.deepToString(args));
    }
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader(File file) {
			try {
				reader = new BufferedReader(new FileReader(file));
				tokenizer = null;
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		
		public String next() throws Exception {
			while(tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public String nextLine() throws Exception {
			String line = null;
			tokenizer = null;
			line = reader.readLine();
			return line;
		}
		
		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		} 
		
		public double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}
		
		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}
	}
}
