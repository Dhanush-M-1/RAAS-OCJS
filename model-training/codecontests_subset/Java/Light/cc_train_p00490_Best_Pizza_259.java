import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] D = new int[N];
		
		for(int i = 0; i < N; i++){
			D[i] = sc.nextInt();
		}
		
		Arrays.sort(D);
		
		int pizzac = C;
		int pizzap = A;
		
		for(int i = N-1; i >= 0; i--){
			if(pizzac / pizzap <= (pizzac + D[i]) / (pizzap + B)){
				pizzac += D[i];
				pizzap += B;
			}
		}
		System.out.println(pizzac/pizzap);
	}
}