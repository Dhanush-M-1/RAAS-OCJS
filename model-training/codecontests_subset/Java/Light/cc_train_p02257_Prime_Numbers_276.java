
import java.util.Scanner;

public class Main {
	
	public static int isPrime(int num) {
		
		for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
			if(num%i == 0) {
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int primeCount = 0;
		int numOfTests = Integer.parseInt(in.next());
		
		for(int i = 0; i < numOfTests; i++) {
			primeCount += isPrime(Integer.parseInt(in.next()));
		}
				
		System.out.println(primeCount);
	}
}

