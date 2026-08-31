
import java.util.Scanner;

public class Main {

	public static int n;
	public static int[] list;

	public static void Calc(int num, int max) {
		if(num == n) {
			String ans = "";
			for(int i = 0; i < n; i++) {
				ans += (char) (list[i] + 'a');
			}
			System.out.println(ans);
		} else {
			for(int i = 0; i < max + 1; i++) {
				list[num] = i;
				if(i < max) {
					Calc(num + 1, max);
				} else {
					Calc(num + 1, max + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		list = new int[n];
		Calc(0, 0);

	}

}
