import java.util.Scanner;

public class Prob195A {
	public static void main(String[] Args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int download = in.nextInt();
		int length = in.nextInt();
		int answer = 0;

		for (;; answer++)
			if ((answer + length) * download >= size * length)
				break;

		System.out.println(answer);
	}
}
