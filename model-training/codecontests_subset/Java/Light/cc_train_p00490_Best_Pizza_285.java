import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// INPUT
		int n = sc.nextInt(); // トッピングの種類
		if(n < 0 || n > 1000) System.exit(-1);
		int a = sc.nextInt(); // 生地の値段
		if(a < 0 || a > 1000) System.exit(-1);
		int b = sc.nextInt(); // トッピングの単価
		if(b < 0 || b > 1000) System.exit(-1);
		int c = sc.nextInt(); // 生地のカロリー
		if(c < 0 || c > 10000) System.exit(-1);
		int[] t_cal = new int[n]; // n種類のトッピングの各カロリー
		for(int i=0; i<n ; i++) {
			t_cal[i] = sc.nextInt();
			if(t_cal[i] < 0 || t_cal[i] > 10000) System.exit(-1);
		}
		int price = a; // 総額
		int sum_cal = c; // 総カロリー
		int best = c / a; // best pizza
		Arrays.sort(t_cal);
		for(int i=n-1; i>=0 ;i--) {
			sum_cal += t_cal[i];
			price += b;
			int tmp = sum_cal / price;
			if(tmp > best) best = tmp;
		}
		System.out.println(best);
	}
}