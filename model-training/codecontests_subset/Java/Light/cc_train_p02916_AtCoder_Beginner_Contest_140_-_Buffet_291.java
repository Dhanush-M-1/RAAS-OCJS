import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
	
	void run() {
		
		int n  =sc.nextInt();
		int[] a = new int[n];
		
		int[] b = new int[n];
		int[] c = new int[n];
		
		for(int i =0 ;i <n;i++) {
			a[i] = sc.nextInt()-1;
		}
		for(int i =0 ; i < n ;i++) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			c[i] = sc.nextInt();
		}
		c[n-1] = 0;
		int prev = -100;
		
		int sum = 0;
		for(int i = 0 ;i < n ;i++) {
			int cur = a[i];
			sum += b[cur];
			if(cur == prev+1) {
				sum += c[prev];
			}
			prev = cur;
		}
		System.out.println(sum);
 	}
}
