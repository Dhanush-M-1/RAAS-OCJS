import java.io.*;
import java.util.*;

public class H {
	private static boolean _READ_FROM_FILE = false;
	private static Scanner in;
	private static void core() {
		int n = in.nextInt();
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (j > 1) System.out.print(" ");
				System.out.print(Integer.toString(i*j, n));
			}
			System.out.println();
		}
	}
	static void debug(Object...os) {
		System.out.println(Arrays.deepToString(os));
	}
	public static void main(String[] args) throws FileNotFoundException {
		in = _READ_FROM_FILE  ? new Scanner(new File("in.in")) : new Scanner(System.in);
		core();
	}
}
