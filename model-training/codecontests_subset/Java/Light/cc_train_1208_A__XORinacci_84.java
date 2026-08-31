import java.util.Scanner;

public class XORinacci {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		int i;
		for(i=0;i<t;i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			
			int j;
			int c = (a|b)&(~a|~b);
			
			if(n%3==0) {
				System.out.println(a);
			}else if((n-1)%3==0) {
				System.out.println(b);
			}else {
				System.out.println(c);
			}
			
			
		}
		
		
	}
	
}
