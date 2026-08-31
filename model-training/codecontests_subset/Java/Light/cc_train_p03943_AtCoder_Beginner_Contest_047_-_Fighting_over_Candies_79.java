import java.util.Scanner;

/**
 * https://abc047.contest.atcoder.jp/tasks/abc047_a
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		String ans = (a+b)==c || (b+c)==a || (c+a)==b ? "Yes" : "No";
		System.out.println(ans);

	}

}