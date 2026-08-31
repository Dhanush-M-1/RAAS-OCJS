import java.util.Scanner;

public class Acm11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int c3 = sc.nextInt();
		int c4 = sc.nextInt();
		int c5 = sc.nextInt();
		int s = c1+c2+c3+c4+c5;
		int r = 0;
		
		if (s == 0){
			System.out.println("-1");
			return;
		}
		if(s % 5 == 0){
			r = s / 5;
			System.out.println(r);
		}else {
			System.out.println("-1");
		}
	}
}