import java.util.Scanner;
public class twentyfive2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n =s.nextLong();
		s.close();
		if(n>=2 && n<=2*Math.pow(10, 18)) {
			System.out.println("25");
		}
	}
}
