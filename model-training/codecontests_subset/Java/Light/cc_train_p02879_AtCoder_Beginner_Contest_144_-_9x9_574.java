import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int a,b;
		Scanner sc= new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		if (a>9 ||b>9||a<1||b<1)
			System.out.print(-1);
		else
			System.out.println(a*b);
	}
}