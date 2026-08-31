import java.util.Arrays;
import java.util.Scanner;

public class Paper {
 
	public static void main(String[] args) {
 
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	
	for(;t>0 ; t--) {
		int n = sc.nextInt();
		
		int a =1;
		int b =0;
		
		while(a>0) {
			if(n%2==0) {
				b = a;
				n = n/2;
				a++;
			}
			
			else {
				break;
			}
		}
		

		
		int c =1;
		int d = 0;
		while(c>0) {
			if(n%3==0) {
				d = c;
				n= n/3;
				c++;
			}
			
			else {
				break;
			}
		}
		

		
		if(n!=1) System.out.println(-1);
		
		else {
			if(b>d) System.out.println(-1);
			
			else {
				System.out.println(2*d-b);
			}
		}
		
	}
	}		
}