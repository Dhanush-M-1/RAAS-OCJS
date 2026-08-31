import java.util.Scanner;

public class NewYearCandles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = 0;
		int h = 0;
		while (a>0){
			h+=a;
			c+=a;
			a = c/b;
			c = c%b;
		}
		System.out.println(h);

	}

}
