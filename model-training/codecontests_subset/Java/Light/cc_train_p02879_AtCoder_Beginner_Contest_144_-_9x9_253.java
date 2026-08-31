import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner src=new Scanner(System.in);
		int a=src.nextInt();
		int b=src.nextInt();
		if(((a>9)||(a<0))||((b>9)||(b<0))) {
			System.out.println(-1);
		}
		else {
			System.out.println(a*b);
		}

	}

}
