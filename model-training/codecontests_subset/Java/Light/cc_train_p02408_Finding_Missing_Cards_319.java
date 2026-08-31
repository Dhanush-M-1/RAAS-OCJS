import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main().run();
	}
	
	private void run() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			set.add(reader.readLine());
		}
		
		Arrays.asList("S", "H", "C", "D").stream().forEach(suit -> {
			IntStream.range(1, 14).forEach(rank -> {
				String card = suit + " " + rank;
				if (!set.contains(card)) {
					System.out.println(card);
				}
			});
		});
	}
}
