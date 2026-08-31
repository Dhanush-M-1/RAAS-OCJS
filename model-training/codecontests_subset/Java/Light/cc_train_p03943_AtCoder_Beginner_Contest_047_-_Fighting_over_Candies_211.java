import java.util.Scanner;
public class Main{
	public static void main(String[]args) {
		Scanner input=new Scanner(System.in);
		int a;
		int b;
		int c;
		do {
			a=input.nextInt();
			b=input.nextInt();
			c=input.nextInt();
		}while(a<1&&a>100&&b<1&&b>100&&c<1&&c>100);
		if((a+b==c)||(a+c==b)||(b+c==a)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}