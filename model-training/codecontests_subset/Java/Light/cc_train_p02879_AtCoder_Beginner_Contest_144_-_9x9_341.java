import java.util.*;

public class Main {

	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int a, b;

		a= sc.nextInt();
		b= sc.nextInt();
		int c = a*b;

		if(a > 9 || b > 9){

			System.out.println("-1");

		}else {

			System.out.println(c);

		}

	}

}