import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class Smile {
	static Scanner in;
	static PrintWriter out;	

	public static void main(String[] args) {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		
		int a = (n * y + 99) / 100 ;
		out.println(Math.max(a - x, 0));
		
		out.close();
	}
}