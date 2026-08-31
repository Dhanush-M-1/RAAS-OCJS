/**
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author sarthak agarwal
 *
 */
public class PhoneNumbers {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader s = new FastReader();
		int n = s.nextInt();
		String str = s.next();
		int count = 0;
		for(int i=0 ; i<n ; i++)
		{
			if(str.charAt(i) == '8')
			{
				count++;
			}
		}
		if(count == 0)
		{
			System.out.println("0");
		}
		else
		{
			int num = n/11;
			if(count>=num)
			{
				System.out.println(num);
			}
			else
			{
				System.out.println(count);
			}
		}
	}
}
