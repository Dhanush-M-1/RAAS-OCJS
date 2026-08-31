import java.util.*;
public class AAndBAndCompilationErrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int a[] = new int[n];
		int b[] = new int[n-1];
		int c[] = new int[n-2];
		
		int suma = 0;
		for(int i = 0 ; i < n ; i++){
			a[i] = in.nextInt();
			suma = suma + a[i];
		}
		
		int sumb = 0;
		for(int i = 0 ; i < n-1 ; i++){
			b[i] = in.nextInt();
			sumb = sumb + b[i];
		}
		
		int sumc = 0;
		for(int i = 0 ; i < n-2 ; i++){
			c[i] = in.nextInt();
			sumc += c[i];
		}
		
		
		System.out.println(suma - sumb);
		System.out.println(sumb - sumc);
		
		
		
		
		
	}

}
