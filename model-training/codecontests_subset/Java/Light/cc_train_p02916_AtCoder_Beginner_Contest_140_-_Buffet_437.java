import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n + 1];
		int b[] = new int[n + 1];
		int c[] = new int[n];
		for (int i = 1; i <= n; ++i)
			a[i] = sc.nextInt();
		for (int i = 1; i <= n; ++i)
			b[i] = sc.nextInt();
		for (int i = 1; i < n; ++i)
			c[i] = sc.nextInt();
		sc.close();
		long ans = 0;
		int pre = -2, crt = 0;
		for(int i = 1; i <= n; ++i){
			crt = a[i];
			ans += b[crt];
			if(crt == pre + 1)ans += c[pre];
			pre = crt;
		}
		System.out.println(ans);
	}
}
