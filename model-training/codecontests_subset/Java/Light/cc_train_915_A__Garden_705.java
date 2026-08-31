import java.util.Scanner;

public class Garden {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int d = 0;
		for(int i = 0; i < n; i ++) {
			int a = sc.nextInt();
			if(a > d) {
				if(k % a == 0) d = a;
			}
		}
		System.out.println(k / d);
	}

}