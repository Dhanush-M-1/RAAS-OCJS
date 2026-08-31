import java.util.Scanner;

public class CodeForce421P1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int v0 = sc.nextInt();
		int v1 = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		int days = 0;
		c-=v0;
		days++;
		while (c>0) {
			int pages = (v0+(days*a))<v1 ? (v0+(days*a)):v1; 
			c-=pages;
			days++;
			c+=l;
		}
		System.out.println(days);
		sc.close();
	}
}
