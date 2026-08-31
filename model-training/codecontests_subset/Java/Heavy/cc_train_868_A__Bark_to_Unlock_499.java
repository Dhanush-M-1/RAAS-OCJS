import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	
	public void solve(Scanner in, PrintWriter out) {
		String pass = in.next();
		char a = pass.charAt(0);
		char b = pass.charAt(1);
		int n = in.nextInt();
		boolean aSecond = false, bFirst = false;
		for(int i = 0; i < n; ++i) {
			String cur = in.next();
			if(cur.charAt(0) == b) bFirst = true;
			if(cur.charAt(1) == a) aSecond = true;
			if(cur.equals(pass)) aSecond = bFirst = true;
		}
		if(aSecond && bFirst) {
			out.println("YES");
		} else {
			out.println("NO");
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		new A().solve(in, out);
		
		in.close();
		out.close();
	}
}
