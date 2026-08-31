import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 

		int n = sc.nextInt();

		int count = 0;
    	for (int i = 0; i < n; i++) {
    		int data = sc.nextInt();
    		if (checkPrimeNum(data)) {
    			count++;
    		}
    	}

    	System.out.println(count);
    	
        sc.close();
	}

	private static boolean checkPrimeNum(int data) {
		if (data == 2) {
			return true;
		}
		if (data % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= (int)Math.sqrt(data) + 1; i += 2) {
			if (data % i == 0) {
				return false;
			}
		}
//		System.out.println("prime: " + data);
		return true;
	}
}