import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class H {

	static int k;

	private static int mult(int x, int y) {
		int m = x * y;
		int r = 0;
		int st = 1;
		while (m != 0) {
			r += (m % k) * st;
			st *= 10;
			m /= k;
		}
		return r;
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner in = new Scanner(new FileInputStream("stdin"));
//		PrintWriter out = new PrintWriter(new FileOutputStream("stdout"));
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		k = in.nextInt();
		for (int i = 1; i < k; i++) {
			for (int j = 1; j < k; j++) {
				if (j != 1) {
					out.print(' ');
				}
				out.print(mult(i, j));
			}
			out.println();
		}

		in.close();
		out.close();
	}

}
