import java.util.Scanner;


public class B {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean div = true;
		int count = 0;
		int adiv2 = 0;
		int bdiv2 = 0;
		int adiv3 = 0;
		int bdiv3 = 0;
		int adiv5 = 0;
		int bdiv5 = 0;
		while(a % 2 == 0){
			adiv2++;
			a/=2;
		}
		while(a % 3 == 0){
			adiv3++;
			a/=3;
		}
		while(a % 5 == 0){
			adiv5++;
			a/=5;
		}
		while(b % 2 == 0){
			bdiv2++;
			b/=2;
		}
		while(b % 3 == 0){
			bdiv3++;
			b/=3;
		}
		while(b % 5 == 0){
			bdiv5++;
			b/=5;
		}
		if(a == b){
			System.out.println(Math.abs(adiv2-bdiv2) + Math.abs(adiv3-bdiv3) + Math.abs(adiv5-bdiv5));
		}
		else{
			System.out.println(-1);
		}
	}
}
