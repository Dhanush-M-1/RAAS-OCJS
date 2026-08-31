import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var a = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
		var b = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
		var c = IntStream.range(0, n - 1).map(i -> sc.nextInt()).toArray();
		sc.close();

		var result = Arrays.stream(b).sum();
		result += IntStream.range(0, n - 1).filter(i -> a[i] + 1 == a[i + 1]).map(i -> c[a[i] - 1]).sum();
		System.out.println(result);
	}
}
