

import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n != 0) {
			String[] a = new String[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.next();
			}
			int j = 1;
			int ans = 0;
			while(j < n) {
				if(a[j-1].equals("lu") && a[j].equals("ru")) {
					ans ++;
				}else if(a[j-1].equals("ru") && a[j].equals("lu")) {
					ans ++;
				}else if(a[j-1].equals("rd") && a[j].equals("ld")) {
					ans ++;
				}else if(a[j-1].equals("ld") && a[j].equals("rd")) {
					ans ++;
				}
				j++;
			}
			System.out.println(ans);
			n = sc.nextInt();
		}
		sc.close();
	}
}

