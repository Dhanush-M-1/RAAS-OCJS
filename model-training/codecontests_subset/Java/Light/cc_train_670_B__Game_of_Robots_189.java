import java.util.Scanner;

public class problema1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int v[] = new int[n+1];
		
		int ans = -1;
		for(int i = 1; i <= n; i++) {
			v[i] = sc.nextInt();
			
			if(k - i <= 0 && ans < 0) {
				ans = v[k];
				break;
			}else {
				k -= i;
			}
		}
		System.out.println(ans);
	}
}
