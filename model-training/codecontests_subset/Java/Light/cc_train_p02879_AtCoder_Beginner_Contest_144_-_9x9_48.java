import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		if(1<=i && i<=9 && j>=1 && j<=9) {
			System.out.println(i*j);
		}else
			System.out.println(-1);
	}

}