import java.util.Scanner;

public class zizo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] s = sc.next().toCharArray();
		for(int a=0;a<n;a++) {
			LOOP: for(int b=1;b<n;b++) {
				for(int i=0;i<=4;i++) {
					int x = a + b * i;
					if (x >= n) {
						continue LOOP;
					}
					if (s[x] == '.') {
						continue LOOP;
					}
				}
				System.out.println("yes");
				return;
			}
		}
		System.out.println("no");
	}
}