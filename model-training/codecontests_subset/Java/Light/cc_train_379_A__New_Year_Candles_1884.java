import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int a, b;
		a = in.nextInt();
		b = in.nextInt();
		int result = 0;
		int t1 = 0;
		while (a > 0){
			result += a;
			t1 += a;
			a = t1 / b;
			t1 = t1 % b;
		}
		
		out.print(result);
		in.close();
		out.close();
	}
}
