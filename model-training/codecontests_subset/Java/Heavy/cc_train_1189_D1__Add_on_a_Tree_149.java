import java.io.*;
import java.util.*;

public class D {

	void run() {
		int n = in.nextInt();
		int[] d = new int[n];

		int i,u,v;
		for(i=0;i<n-1;i++){
			u = in.nextInt() - 1;
			v = in.nextInt() - 1;
			d[u]++;
			d[v]++;
		}

		for(i=0;i<n;i++)
			if(d[i] == 2)
				break;
		
		out.println(i < n ? "NO" : "YES");
	}
	
	static MyScanner in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		boolean stdStream = true;
		if(stdStream){
			in = new MyScanner();
			out = new PrintWriter(System.out);
		}else{
			String fileName = D.class.getSimpleName();
			int n_test = 1;			
			String inputFileName = fileName + String.format(".%02d", n_test) + ".inp";
			String outputFileName = fileName + String.format(".%02d", n_test) + ".out";
			in = new MyScanner(new BufferedReader(new FileReader(inputFileName)));
			out = new PrintWriter(outputFileName);
		}
			
		new D().run();

		in.close();
		out.close();
	}

	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

        MyScanner(){
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

		MyScanner(BufferedReader br) {
			this.br = br;
        }

        void close() throws IOException {
            br.close();
        }
        
		void findToken() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		String next() {
			findToken();
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
	}
}