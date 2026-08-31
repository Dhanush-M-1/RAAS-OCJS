import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			String[] S = new String[N];
			for (int i = 0;i < N;++ i) S[i] = sc.next();
			for (String judge : new String[]{"AC", "WA", "TLE", "RE"}) {
				System.out.printf("%s x %d\n", judge, Arrays.stream(S).filter(judge::equals).count());
			}
		}
	}
}