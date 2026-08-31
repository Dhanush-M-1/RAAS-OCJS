import java.util.Scanner;

public class Problem478A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt(), d = scan.nextInt(), e = scan.nextInt();
		int sum = a+b+c+d+e;
		
		if(sum==0){
			System.out.print("-1");
		}else if(sum%5==0){
			System.out.print(sum/5);
		}else{
			System.out.print("-1");
		}
	}
}