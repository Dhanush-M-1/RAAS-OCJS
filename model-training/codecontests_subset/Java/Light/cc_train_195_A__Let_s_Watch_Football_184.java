import java.io.*;
import java.util.*;
public class Main {
	static Scanner scan = new Scanner (System.in);
	static PrintStream out = System.out;
	
	public static void main (String[] args) {
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int ans  = (a-b)*c/b;
		if ((a-b)*c%b != 0)
			++ans;
		out.println (ans);
	}
	
	
}
