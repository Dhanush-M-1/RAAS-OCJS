
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String str = s.next();
		int[] digit = new int[10];
		for(int i = 0; i < n; i++){
			digit[str.charAt(i) - '0']++;
		}
		int ans = Math.min(digit[8], n / 11);
		System.out.println(ans);


	}

}
