import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cfb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FS in = new FS();
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] robots = new int[n];
		for(int i = 0; i < n; i++){
			robots[i]=in.nextInt();
		}
		for(int i = 0; i < n; i++){
			k-=(i+1);
			if(k<=0){
				k+=i;
				out.println(robots[k]);
				break;
			}
		}
		out.close();
	}
	private static class FS {
		BufferedReader br;
		StringTokenizer st;
		
		public FS () {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch (Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
}
}
