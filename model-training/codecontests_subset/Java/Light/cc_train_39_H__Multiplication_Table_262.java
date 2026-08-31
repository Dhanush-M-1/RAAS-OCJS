import java.util.Scanner;


public class h39 {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int rdx = in.nextInt();
	for (int i = 1; i < rdx; i++) {
		for (int j = 1; j < rdx; j++) {
			System.out.printf("%s ", Integer.toString(i*j, rdx));
		}
		System.out.println();
	}
}
}
