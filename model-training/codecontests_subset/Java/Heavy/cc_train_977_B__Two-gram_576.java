
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Round479B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out=new PrintWriter (new BufferedOutputStream(System.out));
		FastReader s=new FastReader();
		int n=s.nextInt();
		String str=s.next();
		String ans="";
		int maincount=0;
		for(int i=0;i<str.length()-1;i++) {
			StringBuilder helper=new StringBuilder();
			helper.append(str.charAt(i));
			helper.append(str.charAt(i+1));
			int count=0;
			for(int j=0;j<str.length()-1;j++) {
				StringBuilder helper2=new StringBuilder();
				helper2.append(str.charAt(j));
				helper2.append(str.charAt(j+1));
				if(helper.toString().matches(helper2.toString())) {
					count++;
				}
			}
			if(maincount<count) {
				maincount=count;
				ans=helper.toString();
			}
		}
		out.println(ans);
		out.close();
	}
	
	public static PrintWriter out;
	
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		//it reads the data about the specified point and divide the data about it ,it is quite fast
		//than using direct 

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());//converts string to integer
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
