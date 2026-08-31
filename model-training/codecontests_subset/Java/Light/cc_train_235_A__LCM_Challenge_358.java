import java.util.Scanner;
public class LCMChallenge {
	public static void main(String [] args) throws Exception{
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		if(n<3)System.out.println(n);
		else if(n==3)System.out.println(6);
		else {
			
			if(n%2==0){
				long a = 0;
				long b = 0;
				
				if(n%3!=0){
					a = (n*(n-1)*(n-3));	
				}
				n--;
					b = (n*(n-1)*(n-2));
				
				System.out.println(Math.max(a, b));
			}
			else{
				System.out.println(n*(n-1)*(n-2));
			}
		}
	}
}
