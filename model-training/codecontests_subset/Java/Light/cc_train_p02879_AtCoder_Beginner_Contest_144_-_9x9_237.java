import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		int A=stdIn.nextInt();
		int B=stdIn.nextInt();
		if(A>9||B>9)
			System.out.println(-1);
		else
			System.out.println(A*B);
	}
}