import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Main {
	
	public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st=new StringTokenizer("");
	public static String nextStr() throws IOException {
		while (!st.hasMoreTokens()) {
			st=new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextStr());
	}
	static double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextStr());
	}
	static long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextStr());
	}
	public static PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
	public static void printf(String format,Object... args) {
		pw.printf(format, args);
		pw.flush();
	}
	public static void debug(String out) {
		System.out.println(out);
	}
	
	public static final int maxn=(int)1e5+5;
	public static final int inf=0x7f7f7f7f;
	
	public static long ax,ay,bx,by,cx,cy;
	
	public static void main(String[] args) throws IOException {
		ax=nextLong();
		ay=nextLong();
		bx=nextLong();
		by=nextLong();
		cx=nextLong();
		cy=nextLong();
		if ((ax-bx)*(ax-bx)+(ay-by)*(ay-by)==(cx-bx)*(cx-bx)+(cy-by)*(cy-by)&&
			(by-ay)*(cx-ax)!=(cy-ay)*(bx-ax))
			debug("Yes");
		else debug("No");
	}//end
}



