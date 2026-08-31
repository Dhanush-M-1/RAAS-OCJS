import java.util.Scanner;

public class _371B {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();
		
		if (a == b) {
			System.out.print(0);
			return;
		}
		int[] del = {2, 3, 5};
		int[] del_a = new int[del.length];
		int[] del_b = new int[del.length];
		
		for (int i = 0; i < del.length; i++) {
			while (a % del[i] == 0) {
				del_a[i]++;
				a /= del[i];	
			}
			
			while (b % del[i] == 0) {
				del_b[i]++;
				b /= del[i];	
			}
		}
		
		if (a != b) {
			System.out.print(-1);
			return;
		}
		int sum = 0;
		for (int i = 0; i < del.length; i++) {
			sum += Math.abs(del_b[i] - del_a[i]);
		}
		System.out.print(sum);
	}
}