import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B218 {
	public static void main(String[] args) {
		MyScanner scan = new MyScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int a = scan.nextInt(), b=scan.nextInt();
		boolean valid = true;
		
		int ta = a, tb = b;
		while(ta%2==0)ta/=2;
		while(ta%3==0)ta/=3;
		while(ta%5==0)ta/=5;
		while(tb%2==0)tb/=2;
		while(tb%3==0)tb/=3;
		while(tb%5==0)tb/=5;
		if(ta!=tb)valid=false;
		if(!valid){
			out.println(-1);
		}else{
			int gcd = gcd(a,b);
			a/=gcd;
			b/=gcd;
			int count=0;
			while(a%2==0){a/=2;count++;}
			while(a%3==0){a/=3;count++;}
			while(a%5==0){a/=5;count++;}
			while(b%2==0){b/=2;count++;}
			while(b%3==0){b/=3;count++;}
			while(b%5==0){b/=5;count++;}
			out.println(count);
		}
		
		out.close();
	}
	private static int gcd(int a, int b){
		return b==0?a:gcd(b,a%b);
	}
	private static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {br = new BufferedReader(new InputStreamReader(System.in));}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong(){return Long.parseLong(next());}
		double nextDouble(){return Double.parseDouble(next());}
	}
}
