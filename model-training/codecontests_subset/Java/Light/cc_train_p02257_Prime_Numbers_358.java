import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		Main main = new Main();

		int n = scan.nextInt();
		int count = 0;
		for(int i = 0 ; i < n ; i++) {
			int num = scan.nextInt();
			if(num !=1 && main.test(num)) {
				count++;
			}
		}
		System.out.println(count);

	}

	boolean test(int n){
		for (int i = 2 ; i*i <= n ; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}

