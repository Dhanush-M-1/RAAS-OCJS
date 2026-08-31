import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int length = Integer.parseInt(sc.nextLine());
		int count = 0;
		for(int i = 0; i < length; i++) {
			if(primeCheck(Integer.parseInt(sc.nextLine()))) count++;
		}
		sc.close();
		System.out.println(count);
	}
	
	public static boolean primeCheck(int x) {
		double h = Math.sqrt(x);
		for(int i = 2; i <= h; i++) {
			if(x%i == 0) {
				return false;
			}
		}
		return true;
	}
}
