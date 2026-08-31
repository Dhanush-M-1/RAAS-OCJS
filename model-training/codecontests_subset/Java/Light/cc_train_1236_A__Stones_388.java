import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String temp = input.readLine();
		int t = Integer.parseInt(temp);
		int[] a = new int[t];
		int[] b = new int[t];
		int[] c = new int[t];
		for (int i = 0; i < t; i++) {
			temp = input.readLine();
			String[] tempPart = temp.split(" ");
			a[i] = Integer.parseInt(tempPart[0]);
			b[i] = Integer.parseInt(tempPart[1]);
			c[i] = Integer.parseInt(tempPart[2]);
		}
		input.close();
		for (int i = 0; i < t; i++) {
			if (b[i] < c[i] / 2) {
				System.out.println(b[i] * 3);
			} else if (b[i] < c[i] / 2 + 2 * a[i]) {
				System.out.println((c[i] / 2 + (b[i] - c[i] / 2) / 2) * 3);
			} else {
				System.out.println((c[i] / 2 + a[i]) * 3);
			}
		}
	}

}
