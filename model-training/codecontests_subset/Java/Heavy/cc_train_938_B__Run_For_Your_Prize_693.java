import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer out = new StringBuffer();
		
		int n = Integer.parseInt(in.readLine());
		String[] line = in.readLine().split(" ");
		
		int An = 0;
		int Bn = 0;
		
		int temp;
		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(line[i]);
			if (temp <= 500000) {
				An = temp;
			} else {
				Bn = temp;
				break;
			}
		}
		int secondsA = 0;
		int secondsB = 0;
		if (An != 0) {
			secondsA += An - 1;
		}
		if (Bn != 0) {
			secondsB += 1000000 - Bn;
		}
		
		out.append(Math.max(secondsA, secondsB));
		out.append("\n");
		
		System.out.print(out);
	}
}
