import java.io.*;
import java.util.*;

public class zad5a{
	public static void main(String args[])throws IOException{
		new zad5a().run();
	}
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	void run()throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		out.flush();
		out.close();
		in.close();
	}
	void solve()throws IOException{
		Set<String> s = new HashSet<String>();
		String temp;
		long ans = 0;
		while(in.ready()){
			temp = in.readLine();
			switch(temp.charAt(0)){
			case '+':
				s.add(temp.substring(1));
				break;
			case '-':
				s.remove(temp.substring(1));
				break;
			default:
				ans += s.size()*(temp.length()-temp.indexOf(':')-1);
				break;
			}
		}
		out.print(ans);
	}
}
