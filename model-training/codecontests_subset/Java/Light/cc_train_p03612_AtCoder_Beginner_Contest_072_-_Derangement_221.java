import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int p[] = new int[N];
		for(int i = 0; i < N; i++) {
			p[i] = sc.nextInt() - 1;
		}
		
		int ans = 0;
		for(int i = 0; i < N - 1; i++) {
			if(p[i] == i) {
				int temp = p[i];
				p[i] = p[i + 1];
				p[i + 1] = temp;
				ans++;
			}
		}
		if(p[N - 1] == N - 1) {
			ans++;
		}
		System.out.println(ans);
	}
}
