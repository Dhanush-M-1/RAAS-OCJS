
//   http://codeforces.com/problemset/problem/379/A
//   A. New Year Candles



import java.util.Scanner;

public class A03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int h=a;
		while(a>=b){
			h+=a/b;
			int c=a%b;
			a=a/b+c;
		}
		System.out.println(h);	
		
	}
}