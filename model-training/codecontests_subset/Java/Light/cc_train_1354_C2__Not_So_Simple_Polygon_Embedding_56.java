import java.util.Scanner;
 
public class C1_1354 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
		    int n = in.nextInt();
			System.out.println((Math.cos(Math.PI/(4*n)) / Math.sin(Math.PI / (2 * n))) + "");
		}
	}
}