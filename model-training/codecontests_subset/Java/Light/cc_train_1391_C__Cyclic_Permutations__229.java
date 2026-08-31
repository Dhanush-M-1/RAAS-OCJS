import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BitwiseOR {
	public static void main(String args[]){
		Scanner kb=new Scanner(System.in);
		
		int n=kb.nextInt();
		
		long fac=1;
		
		for(long i=1; i<=n; i++) {
			fac*=i;
			fac%=Math.pow(10, 9)+7;
		}
		
		long pow2=1;
		
		for(long i=1; i<=n-1; i++) {
			pow2*=2;
			pow2%=Math.pow(10, 9)+7;
		}
		
		long ans=fac-pow2;
		
		if(fac-pow2<0) {
			ans+=Math.pow(10, 9)+7;
		}
		System.out.println(ans);
	}	
	
}
