import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Woodcutters {

	Woodcutters() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] split;
		int[] x = new int[n];
		int[] h = new int[n];

		for (int i = 0; i < n; i++) {
			split = br.readLine().split(" ");
			x[i] = Integer.parseInt(split[0]);
			h[i] = Integer.parseInt(split[1]);
		}

		int count = 1;
		int prevX = Integer.MIN_VALUE;

		for (int i = 0; i < x.length-1; i++) {
			if (x[i]-h[i] > prevX) {
				count++;
				prevX = x[i];
			} else if (x[i]+h[i] < x[i+1]) {
				count++;
				prevX = x[i]+h[i];
			} else {
				prevX = x[i];
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		new Woodcutters();

	}

}
