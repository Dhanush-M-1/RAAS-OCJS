import java.util.Arrays;
import java.util.Scanner;

public class CR294B {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		int[] a = new int[n];
        int one=0;
        int two=0;
        int three=0;
        
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
			one+=a[i];
		}
		
		int[] b=new int[n-1];
		
		for(int i=0;i<n-1;i++) {
			b[i]=s.nextInt();
			two+=b[i];
		}
		
		int[] c=new int[n-2];
		
		for(int i=0;i<n-2;i++) {
			c[i]=s.nextInt();
			three+=c[i];
		}
		
		System.out.println(one-two);
		System.out.println(two-three);
		
		
		
		
	}
}
