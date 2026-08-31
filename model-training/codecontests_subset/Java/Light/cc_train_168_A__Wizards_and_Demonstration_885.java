import java.util.Scanner;


public class C_114A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int t = 0;
		if (n*y % 100 ==0) t = n*y/100 - x; else t = n*y/100 - x + 1;
		if(t>0) System.out.println(t); else System.out.println(0);
	}
}
