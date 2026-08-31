import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AgainTwentyFive {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		OutputStreamWriter os = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(os);
		long n = in.nextLong();
		if (n == 0)
			pw.println(1);
		else if (n == 1)
			pw.println(5);
		else
			pw.println(25);

		pw.close();
		in.close();
	}
}
