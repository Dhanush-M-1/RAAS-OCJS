import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PhoneNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyScanner input =new MyScanner();
		int n = input.nextInt();
		String s = input.next();
		
		int eights =0;
		for(int i=0; i<n;i++){
			if(s.charAt(i)=='8')eights++;
		}
		System.out.println((int)Math.min(eights,Math.floor(n/11)));
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}

}
