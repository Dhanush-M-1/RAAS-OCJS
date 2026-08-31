import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
	private static BufferedReader in;
	private static StringTokenizer st;
	private static PrintWriter out;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		int ans = 0;
		while(sc.hasNext()){
			String s = sc.nextLine();
			if(s.charAt(0)=='+'){
				list.add(s.substring(1,s.length()));
			}else{
				if(s.charAt(0)=='-'){
					list.remove(list.indexOf(s.substring(1,s.length())));
				}else{
					int t = s.indexOf(':');
					ans += (s.length() - t - 1) * (list.size());
				}
			}
		}
		System.out.println(ans);
	}
	static String next() throws IOException{
		while(!st.hasMoreTokens()){
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
	static int nextInt() throws NumberFormatException, IOException{
		return Integer.parseInt(next());
	}
	static long nextLong() throws NumberFormatException, IOException{
		return Long.parseLong(next());
	}
	
	static double nextDouble() throws NumberFormatException, IOException{
		return Double.parseDouble(next());
	}

}
