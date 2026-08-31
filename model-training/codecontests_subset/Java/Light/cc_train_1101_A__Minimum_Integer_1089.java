import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int d = sc.nextInt();
			if(d<l)System.out.println(d);
			else if(d>r)System.out.println(d);
			else System.out.println(r+(d-r%d));
		}

	}

}
