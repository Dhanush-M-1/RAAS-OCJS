import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		Scanner cd = new Scanner(System.in);
		int a=cd.nextInt();
		int b=cd.nextInt();
		cd.close();
		if((a*b)%2==1) System.out.println("Odd");
		else System.out.println("Even");
	}

}
