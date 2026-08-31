import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();

		int count = 0;
		while(a >= b){
			int temp = a / b;
			int mod = a % b;
			count += a - mod;
			a = temp + mod;
		}
		count += a;
		System.out.println(count);
	}
}