import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for(int i=1;i<n;i++) {
			if(i==p[i]) {
				int tmp = p[i];
				p[i] = p[i+1];
				p[i+1] = tmp;
				cnt++;
			}
		}
		
		if(p[n]==n)
			cnt++;
		
		System.out.println(cnt);
	}
}
