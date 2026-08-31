import java.util.Scanner;

public class A1208 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfTestCases = scan.nextInt();
		while(noOfTestCases-- > 0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			if(n%3==0) {
				System.out.println(a);
			}else if(n%3 == 1) {
				System.out.println(b);
			}else {
				System.out.println(a^b);
			}
		}
	}

}