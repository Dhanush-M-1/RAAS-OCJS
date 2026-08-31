import java.util.Scanner;

public class stones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int runs = sc.nextInt();
		while(runs-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int total = 0;
			while(c>=2&&b>=1) {
				c-=2;
				b--;
				total+=3;
			}
			while(b>=2&&a>=1) {
				b-=2;
				a--;
				total+=3;
			}
			System.out.println(total);
		}

	}

}
