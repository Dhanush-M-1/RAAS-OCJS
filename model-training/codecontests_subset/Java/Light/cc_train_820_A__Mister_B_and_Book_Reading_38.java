import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {

		int c = scanner.nextInt(), v0 = scanner.nextInt(), v1 = scanner.nextInt(), a = scanner.nextInt(),
				l = scanner.nextInt();
		
		int d = 0;
		int v = v0;
		
		while(v < c) {
			d++;
			v += Math.min(v1, v0 + d * a) - l;
		}
	
		System.out.println(d + 1);
	}
}
