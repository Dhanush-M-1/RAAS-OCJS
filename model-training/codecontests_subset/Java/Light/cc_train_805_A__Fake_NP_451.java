import java.util.Scanner;

public class A_FakeNP {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int l = scanner.nextInt(),r = scanner.nextInt();
		scanner.close();
		
		int n = r - l ;
		int x2 =(int) (n/2);
		int x3 =(int) (n/3);
 		if (l == r ) {
			System.out.println(l);
		}
		else if(x2 > x3)
 			System.out.println("2");
 		else if (x3 > x2)
 			System.out.println("3");
 		else {
 			if (l%3 == 0 && r%3 == 0) {
 				System.out.println("3");
			}
 			else
 				System.out.println("2");
 		}
 			
		
	}

}
