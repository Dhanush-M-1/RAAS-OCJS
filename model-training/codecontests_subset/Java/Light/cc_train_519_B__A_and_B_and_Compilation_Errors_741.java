import java.util.*;
 
public class M_Round_6 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
// E. A and B and Compilation Errors
		int t = sc.nextInt(); long suma=0, sumb=0, sumc=0;
		
		long a[] = new long[t];
		long b[] = new long[t-1];
		long c[] = new long[t-2];
		for(int i=0; i<t; i++)	suma+=sc.nextLong();
		for(int i=0; i<t-1; i++)	sumb+=sc.nextLong();
		for(int i=0; i<t-2; i++)	sumc+=sc.nextLong();
			
		System.out.println((suma-sumb) +"\n"+ (sumb-sumc));    
		
	}
}