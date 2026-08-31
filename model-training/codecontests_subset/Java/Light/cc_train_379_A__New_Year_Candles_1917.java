import java.util.Scanner;

public class Candles {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i=0,count=0;
		while(a!=0) {
			a--;
			i++;
			if(i==b) {
				a++;
				i=0;
			}
			count++;
		}
		System.out.println(count);
	}
}