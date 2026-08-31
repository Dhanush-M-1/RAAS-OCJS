import java.util.Scanner;

public class NewYearCandle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int z=a;
		while(a>=b){
			z=z+a/b;
			a=a/b+a%b;
		}
		
		System.out.println(z);

	}

}
