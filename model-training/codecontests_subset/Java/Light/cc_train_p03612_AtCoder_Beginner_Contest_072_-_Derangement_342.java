import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, p[], num[], ans = 0, j = 0;
		
		n = sc.nextInt();
		p = new int[n];
		num = new int[n];
		
		for(int i = 0; i < n; ++i) {
			p[i] = sc.nextInt();
			if(p[i] == i + 1)num[j++] = i;
		}
		sc.close();
		
		if(j != 0) {
			for(int i = 0; i < j; ++i) {
				int tmp = num[i];
				if(tmp < n - 1 && p[tmp + 1] == tmp + 2)
					++i;
				ans++;
			}
		}
		System.out.println(ans);
	}

}
