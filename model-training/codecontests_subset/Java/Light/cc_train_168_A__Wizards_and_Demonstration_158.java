import java.util.*;
import java.io.*;

public class ProblemA {
	Scanner sc = new Scanner(System.in);
	PrintStream out = System.out;

	void start() {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		
		// (x + ans) * 100 / n >= y
		// ans >= y * n / 100 - x
		int ans = Math.max(0, (int)Math.ceil((y * n) / 100.0) - x);
		
		out.println (ans);
		
	}
	
	public static void main(String[] args) {
		new ProblemA().start();
	}

}
