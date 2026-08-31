import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class template {
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner(System.in);
		int T = sc.nextInt();
		int M = sc.nextInt();
		long[] array = new long[M];
		Arrays.fill(array,Long.MAX_VALUE);
		int id = 1;
		for(int i=0;i<T;i++){
			//System.out.println(Arrays.toString(array));
			String next = sc.next();
			if(next.compareTo("alloc")==0){
				//alloc
				int S = sc.nextInt();
				String ans = "NULL";
				loop: for(int a=0;a<=M-S;a++){
					for(int b=0;b<S;b++){
						if(array[b+a]!=Long.MAX_VALUE)continue loop;
					}
					for(int b=0;b<S;b++){
						array[b+a]=id;
					}
					ans = ""+id;
					id++;
					break;
				}
					
				System.out.println(ans);
			}
			else if(next.compareTo("erase")==0){
				int change = sc.nextInt();
				boolean done = false;
				for(int a=0;a<M;a++){
					if(array[a]==change){
						array[a]=Long.MAX_VALUE;
						done = true;
					}
				}
				
				if(!done){
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
				}
				
			}
			else{
				//defrag
				long[] temp = new long[M];
				Arrays.fill(temp,Long.MAX_VALUE);
				int index = 0;
				for(int a=0;a<M;a++){
					if(array[a]==Long.MAX_VALUE)continue;
					temp[index]=array[a];
					index++;
				}
				array=temp;
				
			}
		}

	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream in) throws Exception {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer(br.readLine().trim());
		}

		public int numTokens() throws Exception {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine().trim());
				return numTokens();
			}
			return st.countTokens();
		}

		public String next() throws Exception {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine().trim());
				return next();
			}
			return st.nextToken();
		}

		public double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		public float nextFloat() throws Exception {
			return Float.parseFloat(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public String nextLine() throws Exception {
			return br.readLine().trim();
		}
	}

}
