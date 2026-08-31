import java.util.Scanner;

public class XORanacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int runs = sc.nextInt();
		while(runs-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			if(n%3==0)System.out.println(a);
			else System.out.println(n%3==1?b:a^b);
		}

	}

}
