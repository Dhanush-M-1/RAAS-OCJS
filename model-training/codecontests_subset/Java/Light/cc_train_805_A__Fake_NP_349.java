import java.util.Scanner;

public class zizo {
	public static void main(String[] args) {
		Scanner zizo = new Scanner(System.in);
		int l = zizo.nextInt();
		int r = zizo.nextInt();
		System.out.println(l == r ? l : 2);
	}
}
