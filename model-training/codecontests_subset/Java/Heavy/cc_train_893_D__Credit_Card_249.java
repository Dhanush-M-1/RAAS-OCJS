import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		st = new StringTokenizer(f.readLine());
		int zeroCount = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0)
				zeroCount++;
			array[i] = temp;
		}
		int curr = 0;
		boolean valid = true;
		for (int i = 0; i < N; i++) {
			curr += array[i];
			if (array[i] == 0)
				curr = Math.max(curr, 0);
			if (curr > D) {
				valid = false;
				break;
			}
		}
		int result = 0;
		curr = 0;
		for (int i = 0; i < N; i++) {
			curr += array[i];
			if (array[i] == 0) {
				if (curr < 0) {
					result++;
					curr = D;
				}
			}
			if (curr > D)
				curr = D;
		}
		if (!valid)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	public static void printArray(int[] array) {
		for (int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
}