import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		long MOD = 1000000007L;
 
		String[] tokens = in.readLine().split(" ");
		int N = Integer.parseInt(tokens[0]);
		int M = Integer.parseInt(tokens[1]);
 
		boolean[] statuses = new boolean[N + 1];
		Arrays.fill(statuses, true);
 
		for (int i = 0; i < M; ++i) {
			int index = Integer.parseInt(in.readLine());
			statuses[index] = false;
		}
 
		long[] counts = new long[N + 1];
		Arrays.fill(counts, 0);
		counts[0] = 1;
		if (statuses[1]) {
			counts[1] = 1;
		} else {
			counts[1] = 0;
		}
 
		for (int i = 2; i <= N; ++i) {
			if (statuses[i]) {
				counts[i] = (counts[i - 2] + counts[i - 1]) % MOD;
			} else {
				counts[i] = 0;
			}
		}
		System.out.println(counts[N]);
	}
}