import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 0, M = 0;

		String line;
		while ((line = br.readLine()) != null) {
			String[] n = line.split(",");
			int a = Integer.parseInt(n[0]);
			int b = Integer.parseInt(n[1]);
			int r = Integer.parseInt(n[2]);

			if (a == b) {
				if (r*r != a*a+b*b) M++;
			} else {
				if (r*r == a*a+b*b) N++;
			}
		}
		System.out.println(N);
		System.out.println(M);

	}
}