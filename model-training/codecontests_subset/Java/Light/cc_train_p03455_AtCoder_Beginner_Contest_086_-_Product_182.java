import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int N2=sc.nextInt();
		int count=N*N2;
		if(count%2==0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
	}
}