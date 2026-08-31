
import java.util.ArrayList;
import java.util.Scanner;

public class Ser {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Long n =sc.nextLong();
		ArrayList<Long> tab = new ArrayList<Long>() ;
		int i= 0 ;
		long t ;
		long max = 0 , min = 0 ;
		Long k =sc.nextLong();
		while(i!=n){
			if(i==0) { min = sc.nextLong();tab.add(min);}
			else if(i==n-1){ max =sc.nextLong(); tab.add(max);}
			else { tab.add(sc.nextLong()); }
			i++;
		}
		int x =0 ;
		max=n ;
		min = 1 ;
		while (max-min > 1){
			t= ((max + min ) / 2) ;
			if( k < t*(t+1)/2) { max = t ;}
			else if( k > t*(t+1)/2) { min = t ;}
			else {System.out.println(tab.get((int) t-1));x=1 ;break; }
		}
		if(n==1 || k==1 ){ System.out.println(tab.get(0));}
		else if (x !=1){ System.out.println(tab.get((int) (k- (min*(min+1)/2)-1)));}
	}
}
