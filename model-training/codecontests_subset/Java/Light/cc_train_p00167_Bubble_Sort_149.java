import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			int n = Integer.parseInt(line);
			if (n == 0) {
				break;
			}
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}

			int count = 0;
			for (int i = n - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (array[j] > array[j + 1]) {
						int swap = array[j];
						array[j] = array[j + 1];
						array[j + 1] = swap;
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}