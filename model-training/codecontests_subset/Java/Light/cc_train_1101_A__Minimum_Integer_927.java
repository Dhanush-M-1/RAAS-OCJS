import java.util.Scanner;

public class Minimum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int queries = scan.nextInt();
		while(queries-->0) {
			int l = scan.nextInt(), r = scan.nextInt(), d = scan.nextInt();
			if(l > d) System.out.println(d);
			else System.out.println((r/d)*d+d);
		}

	}

}
