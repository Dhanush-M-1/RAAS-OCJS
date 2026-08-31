import java.util.Scanner;

public class Main{	
		
	public static void main(String[] args){	
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n - 1];
		int[] c = new int[n - 2];
		
		for(int i = 0; i < n; i++)			
			a[i] = scan.nextInt();
		for(int i = 0; i < n - 1; i++)
			b[i] = scan.nextInt();
		for(int i = 0; i < n - 2; i++)
			c[i] = scan.nextInt();
		
		int sum1 = a[n - 1] + a[n - 2] - b[n - 2];
		int sum2 = b[n - 2];
		
		for(int i = 0; i < n - 2; i++){		
			sum1 += a[i] - b[i];
			sum2 += b[i] - c[i];
		}
		
		System.out.println(sum1);
		System.out.println(sum2);		
	}
}






