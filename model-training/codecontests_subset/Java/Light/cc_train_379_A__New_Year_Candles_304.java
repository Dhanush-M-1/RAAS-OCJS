import java.util.Scanner;
public class Candles {

	public static void main(String[] args) {
		int a,b,c,sum=0;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		sum = a;
		
		while(true) {
			c = a/b;
			a= c+(a%b);
			sum = sum+c;
			
			if(a<b) {
				break;
			}
			
		}
		System.out.println(sum);

	}

}