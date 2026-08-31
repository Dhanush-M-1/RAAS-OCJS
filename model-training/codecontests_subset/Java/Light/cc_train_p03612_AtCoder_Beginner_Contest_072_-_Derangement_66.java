
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		int N = scan.nextInt();
		int[] p = new int[N];
		for(int i = 0; i < N; i++) {
			p[i] = scan.nextInt() - 1;
		}
		for(int i = 0; i < N; i++) {
			if(i == p[i]) {
				count++;
				i++;
			}
		}
		System.out.println(count);
		scan.close();
	}

}
