import java.util.Scanner;

public class Main {
	
	
	public boolean prime(int x) {
		
		if(x < 2) {
			return false;
		}
		if(x == 2) {
			return true;
		}
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Main program = new Main();
		int results = 0;
		int size = in.nextInt();
		for(int i = 0; i < size; i++) {
			int value = in.nextInt();
			if(program.prime(value) == true) {
				results++;
			}
		}
		System.out.println(results);
	}
}

