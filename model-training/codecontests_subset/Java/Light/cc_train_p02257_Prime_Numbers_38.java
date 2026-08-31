import java.util.Scanner;

public class Main{

	public static int prime(int a) {
		
		if( a == 0 || a == 1){
			return 0;
		}

		for (int i = 2; i <= Math.sqrt(a); i++) {
			
			if( a % i == 0){
				return 0;
			}

		}
		
		return 1;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();
		
		int c = 0;
		
		for( int i = 0; i < n; i++){
			c += prime(A[i]);
		}
		
		System.out.println(c);

	}

}

