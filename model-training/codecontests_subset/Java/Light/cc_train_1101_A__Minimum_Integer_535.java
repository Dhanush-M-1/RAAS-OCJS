import java.io.PrintWriter;
import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new a().solve(in,out);
		in.close();
		out.close();
	}

	private void solve(Scanner in, PrintWriter out) {
		int Q = in.nextInt();
		for(int q=0; q<Q; q++) {
			int l = in.nextInt();
			int r = in.nextInt();
			int d = in.nextInt();
			if(d<l) System.out.println(d);
			else {
				System.out.println((r/d+1)*d);
			}
		}
		
		
	}
}
