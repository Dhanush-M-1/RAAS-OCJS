import java.util.Scanner;

public class AandBandCompilationErrors519B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int t;
		int a=0,b=0,c=0;
		
		for(int i=0;i<n;i++) {
			t=sc.nextInt();
			a+=t;
		}
		for(int i=0;i<n-1;i++) {
			t=sc.nextInt();
			b+=t;
		}
		for(int i=0;i<n-2;i++) {
			t=sc.nextInt();
			c+=t;
		}
		
		System.out.println(a-b);
		System.out.println(b-c);


	}

}
