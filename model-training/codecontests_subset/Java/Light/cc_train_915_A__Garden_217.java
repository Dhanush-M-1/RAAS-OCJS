import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		int i , j , n , k , ans = - 1;
		n = scan.nextInt();
		k = scan.nextInt();
		for (i = 0;i < n;i ++) {
			int a = scan.nextInt();
			if (k % a == 0) {
				if (k / a < ans || ans < 0) {
					ans = k / a;
				}
			}
		}
		System.out.println(ans);
		
	}
	
}












