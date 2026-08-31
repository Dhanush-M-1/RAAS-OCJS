import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		Main ins = new Main(in);
		ins.calc();
		ins.showResult();
	}

	int N;
	int[] p;

	Main(BufferedReader in) throws IOException {
		N = Integer.parseInt(in.readLine());
		p = new int[N];
		String[] tokens = in.readLine().split(" ");
		for (int i = 0; i < N; ++i) {
			p[i] = Integer.parseInt(tokens[i]) - 1;
		}
	}

	void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	void calc() {
		int count = 0;
		int[] array1 = Arrays.copyOf(p, p.length);
		for (int i = 0; i + 1 < N; ++i) {
			if (array1[i] == i) {
				count++;
				swap(array1, i, i + 1);
			}
		}
		if (array1[N - 1] == N - 1) {
			++count;
			swap(array1, N - 2, N - 1);
		}
		System.out.println(count);
	}

	void showResult() {
	}
}