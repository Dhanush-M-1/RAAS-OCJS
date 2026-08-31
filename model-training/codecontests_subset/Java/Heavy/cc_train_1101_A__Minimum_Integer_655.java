import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {

	static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int q = read();
		for (int index = 0; index < q; index++) {
			int l = read(), r = read(), d = read();
			if (d < l) {
				System.out.println(d);
			} else {
				System.out.println((r / d + 1) * d);
			}
		}

		sc.close();
	}

	static int read() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}

	static String readString() throws IOException {
		in.nextToken();
		return in.sval;
	}
}